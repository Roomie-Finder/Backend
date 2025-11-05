package com.example.roomieFinder.Controller;

import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Services.UserServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("user")
public class UserController {
    private final UserServices userServices;
    @Autowired
    public UserController(UserServices userServices ){
        this.userServices = userServices;
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable ObjectId id){
        return userServices.getUserById(id);
    }

    @PostMapping("login")
    public void userlogin(@RequestBody String email , @RequestBody String password ){

        try{
                userServices.login(email , password);
        }
        catch (Exception e){

        }
    }

    @PostMapping("signup")
    public void createUser(@RequestBody User user ){

        userServices.addUser(user);
    }
}
