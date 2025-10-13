package com.example.roomieFinder.Entities;

import java.util.List;

public class RoomStatus {
    private boolean isLookingForRoom;
    private boolean hasRoomAvailable;
    private List<String> locationPreference;

    public boolean isLookingForRoom() {
        return isLookingForRoom;
    }

    public void setLookingForRoom(boolean lookingForRoom) {
        isLookingForRoom = lookingForRoom;
    }

    public boolean isHasRoomAvailable() {
        return hasRoomAvailable;
    }

    public void setHasRoomAvailable(boolean hasRoomAvailable) {
        this.hasRoomAvailable = hasRoomAvailable;
    }

    public List<String> getLocationPreference() {
        return locationPreference;
    }

    public void setLocationPreference(List<String> locationPreference) {
        this.locationPreference = locationPreference;
    }
}
