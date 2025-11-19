package com.example.roomieFinder.Entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class RoomStatus {
    private String lookingFor;
    private List<String> locationPreference;
    private String preferredRoomType;
}
