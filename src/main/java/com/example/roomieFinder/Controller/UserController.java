package com.example.roomieFinder.Controller;

import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Entities.UserProfile;
import com.example.roomieFinder.UserService.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserServices userService;


    @GetMapping
    public List<User> getUser(){
        return userService.getAllUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user ){
        userService.addUser(user);
        return user;
    }
}
