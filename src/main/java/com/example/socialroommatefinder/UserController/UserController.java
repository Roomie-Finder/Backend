package com.example.socialroommatefinder.UserController;

import com.example.socialroommatefinder.Entities.User;
import com.example.socialroommatefinder.UserService.UserServices;
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
    public String addUser(@RequestBody User user){
        userService.addUser(user);
        return "added user";
    }
}
