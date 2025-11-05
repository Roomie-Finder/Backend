package com.example.roomieFinder.Services;

import com.example.roomieFinder.Entities.Room;
import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Exception.ResourceNotFoundException;
import com.example.roomieFinder.Repository.RoomRepository;
import com.example.roomieFinder.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServices {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomServices(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
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
}
