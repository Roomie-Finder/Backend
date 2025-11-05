package com.example.roomieFinder.Services;

import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Exception.ResourceNotFoundException;
import com.example.roomieFinder.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServices {
    private final UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository userRepository ){
        this.userRepository = userRepository;
    }

    public User addUser(User user ) {
        return userRepository.save(user);
    }

    public User getUserById(ObjectId userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Member not found"));
    }

    public Optional<User> login(String email, String password) {
        System.out.println("enetered userservices");
         return userRepository.findByEmail(email);

    }
}
