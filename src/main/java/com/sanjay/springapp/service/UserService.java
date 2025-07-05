package com.sanjay.springapp.service;


import com.sanjay.springapp.config.UserRepository;
import com.sanjay.springapp.config.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

     private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

     @Autowired
     UserRepository userRep;

     public List<Users> getUser(){
          return userRep.findAll();
     }

     public void singInUser(com.sanjay.springapp.config.Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER" ));
        userRep.save(user);
     }

     public void singInAsADMIN(com.sanjay.springapp.config.Users user){
          user.setPassword(passwordEncoder.encode(user.getPassword()));
          user.setRoles(Arrays.asList("ADMIN"));
          userRep.save(user);
     }

     public void updateUser(Users Newusers , String userName){
          Optional<Users> oldUsername = userRep.findByUsername(userName);
          oldUsername.get().setUsername(Newusers.getUsername());
          oldUsername.get().setPassword(passwordEncoder.encode(Newusers.getPassword()));
          userRep.save(oldUsername.get());
     }


}
