package com.example.roomieFinder.Entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection="Rooms")
@Setter
@Getter
public class Room {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)    
    private ObjectId id;
    private String roomName;
    private String address;
    private int rent;
    private String propertyType;
    private String lookingFor;
    private int deposit;
    private String aboutRoom;
    private List<String> amenities;
    private boolean parkingAvailable;
    @DBRef
    private List<User> members;
    private List<String> roommatePreferences;

}
