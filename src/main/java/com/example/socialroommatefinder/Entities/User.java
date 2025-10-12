package com.example.socialroommatefinder.Entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="Users")
public class User {
    @Id
    private ObjectId id;
    @Indexed
    private String email;
    private String password;
    private String name;
    private Profile profile;

    public User(){
        this.profile= new Profile();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public static class Profile{
        private String occupation;
        private String nativeLanguage;
        private String originCity;
        private int age;
        private List<String> interest;

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

        public String getOriginCity() {
            return originCity;
        }

        public void setOriginCity(String originCity) {
            this.originCity = originCity;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public List<String> getInterest() {
            return interest;
        }

        public void setInterest(List<String> interest) {
            this.interest = interest;
        }

    }

    
}
