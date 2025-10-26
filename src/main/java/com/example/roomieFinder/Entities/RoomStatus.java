package com.example.roomieFinder.Entities;

import java.util.List;

public class RoomStatus {
    private boolean isLookingForRoom;
    private boolean isLookingForRoommate;
    private List<String> locationPreference;
    private String preferredRoomType;

    public boolean isLookingForRoom() {
        return isLookingForRoom;
    }

    public void setLookingForRoom(boolean lookingForRoom) {
        isLookingForRoom = lookingForRoom;
    }

    public boolean isLookingForRoommate() {
        return isLookingForRoommate;
    }

    public void setLookingForRoommate(boolean lookingForRoommate) {
        this.isLookingForRoommate = lookingForRoommate;
    }

    public List<String> getLocationPreference() {
        return locationPreference;
    }

    public void setLocationPreference(List<String> locationPreference) {
        this.locationPreference = locationPreference;
    }

    public String getPreferredRoomType() { return preferredRoomType;}

    public void setPreferredRoomType(String preferredRoomType) { this.preferredRoomType = preferredRoomType;}
}
