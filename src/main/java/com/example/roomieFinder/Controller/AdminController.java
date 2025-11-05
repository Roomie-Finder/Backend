package com.example.roomieFinder.Controller;

import com.example.roomieFinder.Entities.Room;
import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Services.AdminService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("getAllUsers")
    public List<User> getAllUsers(){
        return adminService.getAllUsers();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable ObjectId id){
        return adminService.getUserById(id);
    }

    @DeleteMapping("{userId}")
    public ObjectId deleteUserById(@PathVariable ObjectId userId){
        return adminService.deleteUserById(userId);
    }

    @GetMapping
    public List<Room> getAllRooms(){
        return adminService.getAllRooms();
    }

    @GetMapping("/{roomid}")
    public Room getRoomById(@PathVariable ObjectId roomid){
        System.out.println(adminService.getRoomById(roomid));
        return adminService.getRoomById(roomid);
    }

    @DeleteMapping("{roomId}")
    public ObjectId deleteRoomById(@PathVariable ObjectId roomId){
        return adminService.deleteRoomById(roomId);
    }
}
