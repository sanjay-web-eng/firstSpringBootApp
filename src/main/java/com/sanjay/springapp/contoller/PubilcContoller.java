package com.sanjay.springapp.contoller;

import com.sanjay.springapp.config.JwtUtill;
import com.sanjay.springapp.config.UserDetailsService;
import com.sanjay.springapp.config.Users;
import com.sanjay.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
public class PubilcContoller {
     @Autowired
     private UserService userService;

     @Autowired
     private AuthenticationManager auth;

     @Autowired
     private JwtUtill jwtUtill;

     @Autowired
     private UserDetailsService userDetailsService;
     @PostMapping("/signup")
     public void signup(@RequestBody Users users){
          userService.singInUser(users);
     }

     @PostMapping("/login")
     public String login(@RequestBody Users users){
          try{
               auth.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(),users.getPassword()));
               UserDetails userDetails = userDetailsService.loadUserByUsername(users.getUsername());
               String jwt = jwtUtill.generateToken(userDetails.getUsername());
               return jwt;
          } catch (Exception e) {
               throw new RuntimeException(e);
          }
      }

}
