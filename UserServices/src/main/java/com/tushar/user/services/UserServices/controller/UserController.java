package com.tushar.user.services.UserServices.controller;

import com.tushar.user.services.UserServices.model.User;
import com.tushar.user.services.UserServices.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userServices.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getSingleUser(@PathVariable String id){
        User user =userServices.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    private ResponseEntity<List<User>> getAllUser(){
        List<User> allUser=userServices.getAllUser();
        return ResponseEntity.ok(allUser);
    }
}
