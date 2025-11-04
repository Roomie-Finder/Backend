package com.example.roomieFinder.Repository;

import com.example.roomieFinder.Entities.UserProfile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile , ObjectId> {

}
