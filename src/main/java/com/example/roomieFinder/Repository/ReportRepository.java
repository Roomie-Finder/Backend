package com.example.roomieFinder.Repository;

import com.example.roomieFinder.Entities.Report;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<Report , ObjectId> {
}
