package com.example.roomieFinder.Entities;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserProfiles")
@Setter
@Getter
public class UserProfile {
    @Id
    private ObjectId id;
    private PersonalInfo personalInfo;
    private LifeStyle lifeStyle;
    private RoomStatus roomStatus;

}
