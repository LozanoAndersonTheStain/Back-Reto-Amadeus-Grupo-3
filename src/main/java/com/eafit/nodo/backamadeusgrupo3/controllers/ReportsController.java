package com.eafit.nodo.backamadeusgrupo3.controllers;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.ReportsRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.ReportResponse;
import com.eafit.nodo.backamadeusgrupo3.exeptions.reports.ReportNotFoundException;
import com.eafit.nodo.backamadeusgrupo3.services.ReportsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportsController {

    private final ReportsService reportsService;

    public ReportsController(ReportsService reportsService) {
        this.reportsService = reportsService;
    }

    @PostMapping("/createReport")
    public ResponseEntity<?> createReport(@RequestBody ReportsRequest reportRequest) {
        try {
            // Log the received request
            System.out.println("Received ReportsRequest: " + reportRequest);

            ReportResponse createdReport = reportsService.createReport(reportRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdReport);
        } catch (ReportNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el reporte: " + e.getMessage());
        }
    }

    @GetMapping("/getAllPagedReports")
    public ResponseEntity<?> getAllPagedReports(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<ReportResponse> reports = reportsService.getAllPagedReports(pageable);
            if (reports.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No reports found");
            }
            return ResponseEntity.ok(reports);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/getAllReports")
    public ResponseEntity<?> getAllReports() {
        try {
            if (reportsService.getAllReports().isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No reports found");
            }
            return ResponseEntity.ok(reportsService.getAllReports());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/getReportById/{id}")
    public ResponseEntity<?> getReportById(@PathVariable Long id) {
        try {
            ReportResponse report = reportsService.getReportById(id);
            return ResponseEntity.ok(report);
        } catch (ReportNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}