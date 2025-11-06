package com.example.roomieFinder.Controller;

import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Services.UserServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserServices userServices;

    public UserController(UserServices userServices ){
        this.userServices = userServices;
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable ObjectId id){
        return userServices.getUserById(id);
    }

    @PostMapping("login")
    public ResponseEntity<?> userLogin(@RequestBody User user){
        System.out.println("login");
        Optional<User> userOptional = userServices.login(user);
        if(userOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "invalid username or password"));
        }

        User currUser = userOptional.get();
        System.out.println(currUser.getFirstName());

        if(currUser.getPassword().equals(user.getPassword())){
            return ResponseEntity.ok(currUser);
        }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error" , "Invalid email or password"));
    }

    @PostMapping("signup")
    public ResponseEntity<?> createUser(@RequestBody User user ){
        user.setRole("user");
        System.out.println(user.getRole());
        User newuser =  userServices.addUser(user);
        if (newuser == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Failed to create user. Email may already be in use."));
        }
        System.out.print(newuser.getFirstName());
        return ResponseEntity.ok(newuser);
    }
}
