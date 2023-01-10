package com.springrest.springrest.controller;
import com.springrest.springrest.service.DataService;
import com.springrest.springrest.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class MyController {
    @Autowired
    private DataService dataService;
    @GetMapping("/home")
    public String home(){
        return "Welcome to my REST API";
    }
    @GetMapping("/user")
    public List<User> getUser(){
        return this.dataService.getUser();
    }
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id){
        return this.dataService.getUser(Long.parseLong(id));
    }

    @PostMapping(path = "/user",consumes = "application/json")
    public User addUser(@RequestBody User user){
        return this.dataService.addUser(user);
    }
    @PutMapping("/user")
    public User updateUser(@RequestBody User user){
        return this.dataService.updateUser(user);
    }
    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id){
        try{
            this.dataService.deleteUser(Long.parseLong(id));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
