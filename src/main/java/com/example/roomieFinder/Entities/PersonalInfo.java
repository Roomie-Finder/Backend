package com.example.roomieFinder.Entities;

public class PersonalInfo {
    private String aboutUser;
    private String contactNo;
    private String occupation;
    private String workFromHome;
    private String nativeLanguage;
    private String city;
    private int age;

    public String getAboutUser() {return aboutUser;}

    public void setAboutUser(String aboutUser) {this.aboutUser = aboutUser;}

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(String nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWorkFromHome() {return workFromHome;}

    public void setWorkFromHome(String workFromHome) {this.workFromHome = workFromHome; }
}
