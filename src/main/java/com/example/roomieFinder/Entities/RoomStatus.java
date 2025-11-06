package com.example.roomieFinder.Entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class RoomStatus {
    private boolean isLookingForRoom;
    private boolean isLookingForRoommate;
    private List<String> locationPreference;
    private String preferredRoomType;
}
