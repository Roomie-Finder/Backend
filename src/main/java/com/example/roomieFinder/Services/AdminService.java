package com.example.roomieFinder.Services;

import com.example.roomieFinder.Entities.Room;
import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Exception.ResourceNotFoundException;
import com.example.roomieFinder.Repository.RoomRepository;
import com.example.roomieFinder.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final RoomServices roomServices;
    private final UserServices userServices;

    public AdminService(UserRepository userRepository, RoomRepository roomRepository, RoomServices roomServices, UserServices userServices) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.roomServices = roomServices;
        this.userServices = userServices;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(ObjectId userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Member not found"));
    }

    public ObjectId deleteUserById(ObjectId userId){
        return userRepository.deleteUserById(userId);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(ObjectId roomId) {
        return roomRepository.findById(roomId).orElseThrow(()->new ResourceNotFoundException("Room not found !!"));
    }

    public List<Room> deleteRoomById(ObjectId roomId) {
        System.out.println("roomId d" + roomId);
        Room room = roomServices.getRoomById(roomId);
        User owner = room.getOwner();
        if (owner != null && owner.getRooms() != null) {
            owner.getRooms().removeIf(rid -> rid.equals(roomId));
            userRepository.save(owner);
        }
        roomRepository.deleteById(roomId);
        return roomServices.getAllRooms();
    }
}
