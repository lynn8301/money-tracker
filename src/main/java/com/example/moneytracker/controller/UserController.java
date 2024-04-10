package com.example.moneytracker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.moneytracker.model.User;
import com.example.moneytracker.service.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userID}")
    public Optional<User> getUsersById(@PathVariable("userID") Long userID) {
        Optional<User> result = userService.getUsersById(userID);
        if(result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exist");
        }
        return result;
    }

    @PostMapping()
    public void addUsers(@RequestBody User newUser) {
        userService.addUsers(newUser);
    }
    
    @PutMapping("/{userID}")
    public void updateUser(@PathVariable Long userID, @RequestBody User userChange) {
        userService.updateUser(userID, userChange);
    }

    @DeleteMapping("/{userID}")
    public void deleteById(@PathVariable("userID") Long userID) {
        Optional<User> result = userService.getUsersById(userID);
        if(result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exist");
        }
        userService.deleteById(userID);
    }

}
