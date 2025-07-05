package com.sanjay.springapp.config;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TodoEntry {
     @Id
     private ObjectId id ;

     public String todo ;

     public ObjectId getId() {
          return id;
     }

     public void setId(ObjectId id) {
          this.id = id;
     }

     public String getTodo() {
          return todo;
     }

     public void setTodo(String todo) {
          this.todo = todo;
     }
}
