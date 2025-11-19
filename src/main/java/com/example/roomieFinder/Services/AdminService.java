package com.example.roomieFinder.Services;

import com.example.roomieFinder.Entities.Room;
import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Exception.ResourceNotFoundException;
import com.example.roomieFinder.Repository.RoomRepository;
import com.example.roomieFinder.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final RoomServices roomServices;

    public AdminService(UserRepository userRepository, RoomRepository roomRepository, RoomServices roomServices) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.roomServices = roomServices;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(ObjectId userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Member not found"));
    }

    public void deleteUserById(String userId){
        userRepository.deleteUserById(userId);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(ObjectId roomId) {
        return roomRepository.findById(roomId).orElseThrow(()->new ResourceNotFoundException("Room not found !!"));
    }

    public List<Room> deleteRoomById(ObjectId roomId) {
        System.out.println("roomId d" + roomId);
        roomRepository.deleteById(roomId);
        return roomServices.getAllRooms();
    }
}
