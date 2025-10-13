package com.example.roomieFinder.Entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
public class Room {
    @Id
    private ObjectId id;
    private int rent;
    private String address;
    private int totalRoommates;
    private List<User> members;
    private String propertyType;
    private List<String> parking;
    private int rooms;
    private int bathrooms;
    private boolean isNonVegAllowed;
    private boolean isSmokingAllowed;
    private boolean isDrinkingAllowed;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalRoommates() {
        return totalRoommates;
    }

    public void setTotalRoommates(int totalRoommates) {
        this.totalRoommates = totalRoommates;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public List<String> getParking() {
        return parking;
    }

    public void setParking(List<String> parking) {
        this.parking = parking;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public boolean isNonVegAllowed() {
        return isNonVegAllowed;
    }

    public void setNonVegAllowed(boolean nonVegAllowed) {
        isNonVegAllowed = nonVegAllowed;
    }

    public boolean isSmokingAllowed() {
        return isSmokingAllowed;
    }

    public void setSmokingAllowed(boolean smokingAllowed) {
        isSmokingAllowed = smokingAllowed;
    }

    public boolean isDrinkingAllowed() {
        return isDrinkingAllowed;
    }

    public void setDrinkingAllowed(boolean drinkingAllowed) {
        isDrinkingAllowed = drinkingAllowed;
    }
}
