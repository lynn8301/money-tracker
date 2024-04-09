package com.example.moneytracker.service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moneytracker.model.User;
import com.example.moneytracker.repository.UserRepository;
import com.google.common.hash.Hashing;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUsersById(Long userId) {
        return userRepository.findById(userId);
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    public void addUsers(User newUser){
        String password2Sha256 = Hashing.sha256()
        .hashString(newUser.getPassword(), StandardCharsets.UTF_8)
        .toString();
        newUser.setPassword(password2Sha256);
        userRepository.save(newUser);
    }

    public void updateUser(Long userID, User userChange) {  
        User user = userRepository.findById(userID)
        .orElseThrow(RuntimeException::new);      

        user.setName(userChange.getName());
        user.setEmail(userChange.getEmail());

        String password2Sha256 = Hashing.sha256()
        .hashString(userChange.getPassword(), StandardCharsets.UTF_8)
        .toString();
        if(password2Sha256 != user.getPassword()) user.setPassword(password2Sha256);        
        
        userRepository.save(user);
    }
}
