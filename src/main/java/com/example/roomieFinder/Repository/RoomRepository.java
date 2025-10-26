package com.example.roomieFinder.Repository;

import com.example.roomieFinder.Entities.Room;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, ObjectId> {

}
