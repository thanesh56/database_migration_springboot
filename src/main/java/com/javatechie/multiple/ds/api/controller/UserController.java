package com.javatechie.multiple.ds.api.controller;

import com.javatechie.multiple.ds.api.model.user.User;
import com.javatechie.multiple.ds.api.service.UserService;
import com.javatechie.multiple.ds.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(required = true) int id){
        return userService.getUserById(id);
    }


    @GetMapping("/users")
    public List<User> getAllUser(){
       return userService.getAllUser();
    }

    @PostMapping("/users")
    public User addAllUser(@RequestBody(required = true) User user){
        return userService.saveUser(user);
    }

    @DeleteMapping("/users")
    public void deleteAllUser(){
        userService.deleteUser();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable(required = true) int id){
        userService.deleteUserById(id);
    }
}
