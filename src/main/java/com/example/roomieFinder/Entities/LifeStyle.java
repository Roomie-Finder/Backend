package com.example.roomieFinder.Entities;

import java.util.List;

public class LifeStyle {
    private String socialHabits;
    private boolean wfhStatus;
    private List<String> hobbies;
    private boolean smoking;

    public String getSocialHabits() {
        return socialHabits;
    }

    public void setSocialHabits(String socialHabits) {
        this.socialHabits = socialHabits;
    }

    public boolean isWfhStatus() {
        return wfhStatus;
    }

    public void setWfhStatus(boolean wfhStatus) {
        this.wfhStatus = wfhStatus;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public boolean isDrinking() {
        return drinking;
    }

    public void setDrinking(boolean drinking) {
        this.drinking = drinking;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    private boolean drinking;
}
