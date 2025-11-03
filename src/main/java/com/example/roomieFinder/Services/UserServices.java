package com.example.roomieFinder.Services;

import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Entities.UserProfile;
import com.example.roomieFinder.Exception.ResourceNotFoundException;
import com.example.roomieFinder.Repository.UserProfileRepository;
import com.example.roomieFinder.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserServices(UserRepository userRepository , UserProfileRepository userProfileRepository){
        this.userProfileRepository = userProfileRepository;
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user ) {
        UserProfile userProfile = user.getUserProfile();
        UserProfile savedProfile = userProfileRepository.save(userProfile);
        user.setUserProfile(savedProfile);
        userRepository.save(user);
    }

    public User getUserById(ObjectId userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Member not found"));
    }
}
