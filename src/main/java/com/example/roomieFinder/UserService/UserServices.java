package com.example.roomieFinder.UserService;

import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Entities.UserProfile;
import com.example.roomieFinder.Repository.UserProfileRepository;
import com.example.roomieFinder.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user ) {
        UserProfile userProfile = user.getUserProfile();
        UserProfile savedProfile = userProfileRepository.save(userProfile);
        user.setUserProfile(savedProfile);
        System.out.println(savedProfile);
        userRepository.save(user);
    }
}
