package com.example.roomieFinder.Entities;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Reports")
@Setter
@Getter
public class Report {
    @Id
    private String id;
    private String roomId;
    private String contactInfo;
    private String description;

}
