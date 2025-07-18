package com.sanjay.springapp.config;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "user")
public class Users {
     @Id
     public ObjectId id ;

     @Indexed(unique = true)
     private String username;

     private String password;

     private List<String> roles;










     public Users(String username, String password) {
          this.username = username;
          this.password = password;
     }

     public List<String> getRoles() {
          return roles;
     }

     public void setRoles(List<String> roles) {
          this.roles = roles;
     }

     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }

     public ObjectId getId() {
          return id;
     }

     public void setId(ObjectId id) {
          this.id = id;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }
}
