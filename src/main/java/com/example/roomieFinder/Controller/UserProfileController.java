package com.example.roomieFinder.Controller;

import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Services.UserServices;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("userProfile")
public class UserProfileController {

    private final UserServices userServices;

    public UserProfileController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/{uid}")
    public ResponseEntity<?> updateProfile( @PathVariable ObjectId uid,@RequestBody User user){
        System.out.println(uid+"update profile");
        ObjectId profileId = userServices.updateProfile(uid , user);
        if(profileId != null){
            ResponseEntity.ok(200);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error" ,"Error updating profile"));
    }

}
