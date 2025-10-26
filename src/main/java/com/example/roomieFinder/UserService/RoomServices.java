package com.example.roomieFinder.UserService;

import com.example.roomieFinder.Entities.Room;
import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Exception.ResourceNotFoundException;
import com.example.roomieFinder.Repository.RoomRepository;
import com.example.roomieFinder.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServices {
    private final RoomRepository roomRepository;
    private final UserServices userServices;
    private final UserRepository userRepository;

    @Autowired
    public RoomServices(RoomRepository roomRepository, UserServices userServices, UserRepository userRepository){
        this.roomRepository = roomRepository;
        this.userServices = userServices;
        this.userRepository = userRepository;
    }

    public void createRoom(Room room){
        roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(ObjectId roomId) {
        return roomRepository.findById(roomId).orElseThrow(()->new ResourceNotFoundException("Room not found !!"));
    }

    public boolean addNewMember(ObjectId roomId , ObjectId userId) {
        User user = userServices.getUserById(userId);
        List<ObjectId> userRooms= user.getRooms();
        Room room = getRoomById(roomId);
        List<User> members = room.getMembers();
        members.add(user);
        roomRepository.save(room);
        userRooms.add(room.getId());
        userRepository.save(user);
        return true;
    }
}
