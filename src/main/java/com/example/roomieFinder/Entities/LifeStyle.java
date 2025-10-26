package com.example.roomieFinder.Entities;

import java.util.List;

public class LifeStyle {
    private List<String> socialHabits;
    private List<String> interests;
    private List<String> smokingDrinkingHabbit;
    private String sleepSchedule;

    public List<String> getSocialHabits() {
        return socialHabits;
    }

    public void setSocialHabits(List<String> socialHabits) {
        this.socialHabits = socialHabits;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public void setSmokingDrinkingHabbit(List<String> smokingDrinkingHabbit) {
        this.smokingDrinkingHabbit = smokingDrinkingHabbit;
    }

    public List<String> getSmokingDrinkingHabbit() {
        return smokingDrinkingHabbit;
    }

    public String getSleepSchedule() {
        return sleepSchedule;
    }

    public void setSleepSchedule(String sleepSchedule) {
        this.sleepSchedule = sleepSchedule;
    }
}
