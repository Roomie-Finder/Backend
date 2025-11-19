package com.example.roomieFinder.Services;

import com.example.roomieFinder.Entities.Room;
import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Exception.ResourceNotFoundException;
import com.example.roomieFinder.Repository.RoomRepository;
import com.example.roomieFinder.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServices {
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;
    private final UserServices userServices;

    public RoomServices(RoomRepository roomRepository, UserRepository userRepository, UserServices userServices){
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
        this.userServices = userServices;
    }

    public void createRoom(Room room, ObjectId id) {
        User user = userServices.getUserById(id);
        List<User> members = new ArrayList<>();
        members.add(user);
        room.setMembers(members);
        room.setOwner(user);
        roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(ObjectId roomId) {
        return roomRepository.findById(roomId).orElseThrow(()->new ResourceNotFoundException("Room not found !!"));
    }

    public Room AddRoomMember(ObjectId uid , ObjectId rid){
        Room room = getRoomById(rid);
        User user = userServices.getUserById(uid);
        List<User> list = room.getMembers();
        boolean alreadyExists = list.stream()
                .anyMatch(member -> member.getId().equals(uid));
        if(alreadyExists){
            return null;
        }
        room.getMembers().add(user);
        roomRepository.save(room);
        return room;
    }

    public Room removeRoomMember(ObjectId uid , ObjectId rid){
        Room room = getRoomById(rid);
        List<User> list = room.getMembers();
        if(!room.getOwner().getId().equals(uid)) list.removeIf(user->user.getId().equals(uid));
        room.setMembers(list);
        return room;
    }

    public List<Room> getUserRooms(ObjectId uid) {
        return roomRepository.findByOwnerId(uid);
    }

    public Room updateRoom(Room room , ObjectId roomId) {
        roomRepository.save(room);
        Optional<Room> rooms =  roomRepository.findById(room.getId());
        return rooms.orElse(null);
    }
}
