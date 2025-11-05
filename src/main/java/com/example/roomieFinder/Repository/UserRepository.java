package com.example.roomieFinder.Repository;

import com.example.roomieFinder.Entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    ObjectId deleteUserById(ObjectId userId);
    User findByEmail(String email);
}
