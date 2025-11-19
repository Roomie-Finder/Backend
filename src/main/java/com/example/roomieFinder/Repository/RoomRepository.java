package com.example.roomieFinder.Repository;

import com.example.roomieFinder.Entities.Room;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends MongoRepository<Room, ObjectId> {
    List<Room> findByOwnerId(ObjectId id);
    ObjectId deleteRoomById(ObjectId id);
}
