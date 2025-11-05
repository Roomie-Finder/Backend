package com.example.roomieFinder.Services;

import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Exception.ResourceNotFoundException;
import com.example.roomieFinder.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServices {
    private final UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository userRepository ){
        this.userRepository = userRepository;
    }

    public void addUser(User user ) {
        userRepository.save(user);
    }

    public User getUserById(ObjectId userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Member not found"));
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if(user != null){
            if(user.getPassword().equals(password)){
                return user;
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }
}
