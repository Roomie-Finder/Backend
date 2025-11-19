package com.example.roomieFinder.Controller;

import com.example.roomieFinder.Entities.Room;
import com.example.roomieFinder.Repository.RoomRepository;
import com.example.roomieFinder.Services.RoomServices;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomServices roomServices;
    private final RoomRepository roomRepository;


    @GetMapping("")
    public List<Room> getAllRooms(){
        return roomServices.getAllRooms();
    }

    @PostMapping("/create/{uid}")
    public void createRoom(@RequestBody Room room , @PathVariable ObjectId uid){
        roomServices.createRoom(room,uid);
    }

    @GetMapping("/{roomid}")
    public Room getRoomById(@PathVariable ObjectId roomid){
        return roomServices.getRoomById(roomid);
    }
    @GetMapping("user/{uid}")
    public ResponseEntity<?> getUserRooms(@PathVariable ObjectId uid){
        List<Room> rooms = roomServices.getUserRooms(uid);
        if(rooms != null){
            return ResponseEntity.ok(rooms);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error" , "error fetching user rooms"));
    }

    @PostMapping("/update/{roomId}")
    public ResponseEntity<?> updateRoom(@RequestBody Room room , @PathVariable ObjectId roomId){
        System.out.println(roomId);
        return ResponseEntity.ok(roomServices.updateRoom(room , roomId));
    }
    @PostMapping("/member/add")
    public ResponseEntity<?> addRoomMember(@RequestBody Map<String ,ObjectId > map){
        ObjectId uid = map.get("uid");
        ObjectId rid = map.get("rid");
        Room room = roomServices.AddRoomMember(uid ,rid);
        if( room != null){
            return ResponseEntity.ok(room);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error " , "error adding member"));
    }

    @PostMapping("/member/remove")
    public ResponseEntity<?> removeRoomMember(@RequestBody Map<String ,ObjectId > map){
        ObjectId uid = map.get("uid");
        ObjectId rid = map.get("rid");
        Room room = roomServices.removeRoomMember(uid ,rid);
        roomRepository.save(room);

        if(room.getMembers() != null){
            return ResponseEntity.ok(room);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error " , "error adding member"));
    }
}
