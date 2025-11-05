package com.example.roomieFinder.Services;

import com.example.roomieFinder.Entities.Room;
import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Exception.ResourceNotFoundException;
import com.example.roomieFinder.Repository.RoomRepository;
import com.example.roomieFinder.Repository.UserProfileRepository;
import com.example.roomieFinder.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public AdminService(UserRepository userRepository, RoomRepository roomRepository) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
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

    public ObjectId deleteRoomById(ObjectId roomId){
        return roomRepository.deleteRoomById(roomId);
    }
}
