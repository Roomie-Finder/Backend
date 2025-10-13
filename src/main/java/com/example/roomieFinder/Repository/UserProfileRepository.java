package com.example.roomieFinder.Repository;

import com.example.roomieFinder.Entities.UserProfile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile , ObjectId> {

}
