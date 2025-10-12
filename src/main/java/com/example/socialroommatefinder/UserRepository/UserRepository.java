package com.example.socialroommatefinder.UserRepository;

import com.example.socialroommatefinder.Entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
}
