package com.sanjay.springapp.contoller;


import com.sanjay.springapp.config.Users;
import com.sanjay.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserContoller {
     @Autowired
     private UserService userService;
     @PostMapping("/update-user")
     public void updateUser(@RequestBody Users users){
          Authentication auth = SecurityContextHolder.getContext().getAuthentication();
          String userName = auth.getName();
          userService.updateUser(users , userName);
     }
}
