package com.example.roomieFinder.Controller;


import com.example.roomieFinder.Entities.Report;
import com.example.roomieFinder.Services.AdminService;
import com.example.roomieFinder.security.ReportServices;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {
    private final ReportServices reportServices;
    private final AdminService adminService;

    @GetMapping("/{id}")
    public Report getReportById(@PathVariable ObjectId id){
        Optional<Report> report=  reportServices.getReportById(id);
        return report.orElse(null);
    }

    @PostMapping("/new")
    public ResponseEntity<?> createReport(@RequestBody Report report){
        System.out.println("entered report route");
        Report savedReport = reportServices.createNewReport(report);
        return ResponseEntity.ok(savedReport);
    }

    @PostMapping("/room/{roomId}")
    public ResponseEntity<?> createRoomReport(@RequestBody Report report){
        Report savedReport = reportServices.createNewReport(report);
        return ResponseEntity.ok(savedReport);
    }


    @DeleteMapping("/{id}")
    public List<Report> deleteReport(@PathVariable ObjectId id){
        reportServices.deleteReport(id);
        return adminService.getAllReports();
    }

}
