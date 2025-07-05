package com.sanjay.springapp.contoller;

import com.sanjay.springapp.config.TodoEntry;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class EntryContoller {

     private List<String> j = new ArrayList<>(Arrays.asList("a","b","c"));

     @GetMapping("/get-journal")
     public List<String> getALl(){
          return j;
     }
}
