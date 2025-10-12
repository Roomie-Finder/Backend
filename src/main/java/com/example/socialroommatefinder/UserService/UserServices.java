package com.example.socialroommatefinder.UserService;

import com.example.socialroommatefinder.Entities.User;
import com.example.socialroommatefinder.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
}
