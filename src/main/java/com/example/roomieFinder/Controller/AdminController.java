package com.example.roomieFinder.Controller;

import com.example.roomieFinder.Entities.Room;
import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Services.AdminService;
import com.example.roomieFinder.Services.UserServices;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final UserServices userServices;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return adminService.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable ObjectId userId){
        return adminService.getUserById(userId);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable String userId){
         adminService.deleteUserById(userId);
         List<User> users = adminService.getAllUsers();
         return ResponseEntity.ok(users);

    }

    @GetMapping("getAllRooms")
    public List<Room> getAllRooms(){
        return adminService.getAllRooms();
    }

    @GetMapping("/room/{roomId}")
    public Room getRoomById(@PathVariable ObjectId roomId){
        System.out.println(adminService.getRoomById(roomId));
        return adminService.getRoomById(roomId);
    }

    @DeleteMapping("/deleteRoom/{roomId}")
    public ResponseEntity<?> deleteRoomById(@PathVariable ObjectId roomId){
        List<Room> rooms= adminService.deleteRoomById(roomId);
        if(rooms!=null){
            return ResponseEntity.ok(rooms);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error" , "listing not found"));
    }
}
