package com.example.roomieFinder.Entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="Users")
@Setter
@Getter
public class User {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String firstName;
    private String lastName;
    @Indexed
    private String email;
    private String password;
    private String role;
    @DBRef
    private UserProfile userProfile;
    @JsonSerialize(using = ToStringSerializer.class)
    private List<ObjectId> rooms;



}
