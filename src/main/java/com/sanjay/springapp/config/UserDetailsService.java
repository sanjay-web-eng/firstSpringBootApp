package com.sanjay.springapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
     @Autowired
     private UserRepository userRepo;

     @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          Users users = userRepo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("user not found"));
          return User.builder()
                  .username(users.getUsername())
                  .password(users.getPassword())
                  .roles(users.getRoles().toArray(new String[0]))
                  .build();
     }
}
