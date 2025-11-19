package com.example.roomieFinder.Repository;

import com.example.roomieFinder.Entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    void deleteUserById(String userId);
    Optional<User> findByUsername(String username);
}
