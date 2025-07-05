package com.sanjay.springapp.service;

import com.sanjay.springapp.config.TodoEntry;
import com.sanjay.springapp.config.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import java.util.List;
//import java.util.Optional;
//
//
//@Component
//public class TodoEntryService  {
//
//     @Autowired
//     private UserRepository todoEntryRepository;
//
//     public void todoEntry(TodoEntry todoEntry){
//          todoEntryRepository.save(todoEntry);
//     }
//
//     public List<TodoEntry> getData(){
//          return todoEntryRepository.findAll();
//     }
//
//     public void deleteTodo(ObjectId id){
//          todoEntryRepository.deleteById(String.valueOf(id));
//     }
//
//     public Optional<TodoEntry> findbyid(ObjectId id){
//
//          return  todoEntryRepository.findById(String.valueOf(id));
//     }
//}
