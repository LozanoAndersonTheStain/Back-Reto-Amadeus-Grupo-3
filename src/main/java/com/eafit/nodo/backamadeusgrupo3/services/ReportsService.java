package com.eafit.nodo.backamadeusgrupo3.services;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.ReportsRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.ReportResponse;
import com.eafit.nodo.backamadeusgrupo3.entities.ReportsEntity;
import com.eafit.nodo.backamadeusgrupo3.entities.UserEntity;
import com.eafit.nodo.backamadeusgrupo3.exeptions.reports.ReportNotFoundException;
import com.eafit.nodo.backamadeusgrupo3.mappers.interfaces.ReportMapper;
import com.eafit.nodo.backamadeusgrupo3.repositories.ReportsRepository;
import com.eafit.nodo.backamadeusgrupo3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportsService {

    private final ReportsRepository reportsRepository;
    private final ReportMapper reportsMapper;
    private final UserRepository userRepository;
    private final UserQueryService userQueryService;

    @Autowired
    public ReportsService(ReportsRepository reportsRepository, ReportMapper reportsMapper, UserRepository userRepository, UserQueryService userQueryService) {
        this.reportsRepository = reportsRepository;
        this.reportsMapper = reportsMapper;
        this.userRepository = userRepository;
        this.userQueryService = userQueryService;
    }

    @Transactional
public ReportResponse createReport(ReportsRequest reportsRequest) {
    try {
        UserEntity user = userRepository.findById(reportsRequest.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        ReportsEntity report = ReportsEntity.builder()
                .reportTime(reportsRequest.getReportTime())
                .reportData(reportsRequest.getReportData())
                .user(user)
                .build();
        reportsRepository.save(report);

        reportsRequest.getUserQueries().forEach(userQueryRequest -> {
            userQueryService.createUserQuery(userQueryRequest, report);
        });

        ReportsEntity savedReport = reportsRepository.findById(report.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Report not found after saving"));

        savedReport.setUserQueries(userQueryService.findByReportId(savedReport.getId()));

        return reportsMapper.toReportResponse(savedReport);
    } catch (ResponseStatusException e) {
        throw e;
    } catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error creating report", e);
    }
}

    public Page<ReportResponse> getAllPagedReports(Pageable pageable) {
        try {
            Page<ReportsEntity> reportsPage = reportsRepository.findAll(pageable);
            return reportsPage.map(reportsMapper::toReportResponse);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving paginated reports", e);
        }
    }

    public List<ReportResponse> getAllReports() {
        try {
            List<ReportsEntity> reports = reportsRepository.findAll();
            return reports.stream()
                    .map(reportsMapper::toReportResponse)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving reports", e);
        }
    }

    public ReportResponse getReportById(Long id) {
        try {
            return reportsRepository.findById(id)
                    .map(reportsMapper::toReportResponse)
                    .orElseThrow(() -> new ReportNotFoundException("Report not found with id " + id));
        } catch (ReportNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Report not found with id " + id, e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving report by id", e);
        }
    }
}