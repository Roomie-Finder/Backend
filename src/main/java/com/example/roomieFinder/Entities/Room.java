package com.example.roomieFinder.Entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection="Rooms")
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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getRent() {
        return rent;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public String getLookingFor() {
        return lookingFor;
    }

    public void setLookingFor(String lookingFor) {
        this.lookingFor = lookingFor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getAboutRoom() {
        return aboutRoom;
    }

    public void setAboutRoom(String aboutRoom) {
        this.aboutRoom = aboutRoom;
    }

    public boolean isParkingAvailable() {
        return parkingAvailable;
    }

    public void setParkingAvailable(boolean parkingAvailable) {
        this.parkingAvailable = parkingAvailable;
    }

    public List<String> getRoommatePreferences() {
        return roommatePreferences;
    }

    public void setRoommatePreferences(List<String> roommatePreferences) {
        this.roommatePreferences = roommatePreferences;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

}
