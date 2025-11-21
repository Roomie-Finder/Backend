package com.example.roomieFinder.security;

import com.example.roomieFinder.Entities.Report;
import com.example.roomieFinder.Repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportServices {
    private final ReportRepository reportRepository;

    public Report createNewReport(Report report){
        return reportRepository.save(report);
    }

    public Optional<Report> getReportById(ObjectId id) {
        return reportRepository.findById(id);
    }

    public void deleteReport(ObjectId id) {
        reportRepository.deleteById(id);
    }
}
