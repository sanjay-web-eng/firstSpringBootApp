package com.sanjay.springapp.contoller;


import com.sanjay.springapp.config.Users;
import com.sanjay.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminContoller {
     @Autowired
     private UserService userService;
     @GetMapping("/get-all-users")
     public List<Users> getUsers(){
          return userService.getUser();
     }
     @PostMapping("/set-admin")
     public void saveAdmin(@RequestBody Users users){
          userService.singInAsADMIN(users);
     }
}
