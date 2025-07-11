package com.sanjay.springapp.service;


import com.sanjay.springapp.config.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;


@Configuration
@EnableWebSecurity
public class SpringSecurity {
     @Autowired
     private UserDetailsService userdetailsservice;

     @Autowired
     private JwtFilter jwtFilter;

     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
          return http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(request -> request
                          .requestMatchers("/journal/**" , "/user/**").authenticated()
                          .requestMatchers("/admin/**").hasRole("ADMIN")
                          .anyRequest().permitAll()).sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                  .addFilterBefore(jwtFilter , UsernamePasswordAuthenticationFilter.class)
                  .build();
     }
     @Autowired
     public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
          auth.userDetailsService(userdetailsservice).passwordEncoder(passwordEncoder());
     }
     @Bean
     public PasswordEncoder passwordEncoder() {
          return new BCryptPasswordEncoder();
     }

     @Bean
     public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
          return config.getAuthenticationManager();
     }

}
