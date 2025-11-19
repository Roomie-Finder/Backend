package com.example.roomieFinder.Controller;

import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Services.UserServices;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("userProfile")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserServices userServices;

    @PostMapping("/{uid}")
    public ResponseEntity<?> updateProfile( @PathVariable ObjectId uid,@RequestBody User user){
        System.out.println(uid+"update profile");
        ObjectId profileId = userServices.updateProfile(uid , user);
        System.out.println("profileid :"+profileId);
        if(profileId != null){
            return ResponseEntity.ok(200);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error" ,"Error updating profile"));
    }

}
