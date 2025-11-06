package com.example.roomieFinder.Services;

import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Entities.UserProfile;
import com.example.roomieFinder.Exception.ResourceNotFoundException;
import com.example.roomieFinder.Repository.UserProfileRepository;
import com.example.roomieFinder.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServices {
    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;

    public UserServices(UserRepository userRepository, UserProfileRepository userProfileRepository){
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
    }

    public User addUser(User user ) {
        return userRepository.save(user);
    }

    public User getUserById(ObjectId userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Member not found"));
    }

    public Optional<User> login(User user) {
        System.out.println("Entered userServices");
           Optional<User> optionalUser =  userRepository.findByEmail(user.getEmail());
           if(optionalUser.isPresent()){
               User newuser = optionalUser.get();
               if( newuser.getPassword().equals(user.getPassword())){
                   return Optional.of(newuser);
               }
           }
         return Optional.empty();
    }

    public ObjectId updateProfile(ObjectId uid, User userRequest) {
        User existingUser = userRepository.findById(uid)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + uid));
        UserProfile profileDataFromRequest = userRequest.getUserProfile();
        UserProfile existingProfile = existingUser.getUserProfile();
        if (existingProfile == null) {
            existingProfile = new UserProfile();
        }
        if (profileDataFromRequest != null) {
            existingProfile.setPersonalInfo(profileDataFromRequest.getPersonalInfo());
            existingProfile.setLifeStyle(profileDataFromRequest.getLifeStyle());
            existingProfile.setRoomStatus(profileDataFromRequest.getRoomStatus());
        }
        UserProfile savedProfile = userProfileRepository.save(existingProfile);
        existingUser.setFirstName(userRequest.getFirstName());
        existingUser.setLastName(userRequest.getLastName());
        existingUser.setEmail(userRequest.getEmail());
        existingUser.setUserProfile(savedProfile);

        userRepository.save(existingUser);

        return savedProfile.getId();
    }
}
