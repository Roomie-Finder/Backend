package com.example.roomieFinder.Controller;

import com.example.roomieFinder.Entities.Room;
import com.example.roomieFinder.Services.RoomServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("room")
public class RoomController {
    private final RoomServices roomServices;

    @Autowired
    public RoomController(RoomServices roomServices){
        this.roomServices = roomServices;
    }

    @GetMapping("")
    public List<Room> getAllRooms(){
        return roomServices.getAllRooms();
    }

    @PostMapping("/create")
    public void createRoom(@RequestBody Room room){
        roomServices.createRoom(room);
    }

    @GetMapping("/{roomid}")
    public Room getRoomById(@PathVariable ObjectId roomid){
        System.out.println(roomServices.getRoomById(roomid));
        return roomServices.getRoomById(roomid);
    }
//    @GetMapping("/{roomId}")
//    public String addMember(@PathVariable ObjectId roomId ,@RequestParam(value = "userId", required = true) ObjectId userId){
//        System.out.println(roomId+" "+userId);
//        boolean added =  roomServices.addNewMember(roomId , userId);
//        return added?"added new member":" something went wrong";
//    }
}
