package com.example.roomieFinder.Controller;

import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Services.UserServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("user")
public class UserController {
    private final UserServices userServices;
    @Autowired
    public UserController(UserServices userServices){
        this.userServices = userServices;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userServices.getAllUsers();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable ObjectId id){
        return userServices.getUserById(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user ){
        userServices.addUser(user);
    }
}
