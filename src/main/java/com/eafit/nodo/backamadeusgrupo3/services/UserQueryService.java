package com.eafit.nodo.backamadeusgrupo3.services;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.UserQueryRequest;
import com.eafit.nodo.backamadeusgrupo3.entities.ReportsEntity;
import com.eafit.nodo.backamadeusgrupo3.entities.UserQuerysEntity;
import com.eafit.nodo.backamadeusgrupo3.mappers.implementation.UserQueryMapper;
import com.eafit.nodo.backamadeusgrupo3.repositories.UserQueryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserQueryService {

    private final UserQueryRepository userQueryRepository;
    private final UserQueryMapper userQueryMapper;

    @Autowired
    public UserQueryService(UserQueryRepository userQueryRepository, UserQueryMapper userQueryMapper) {
        this.userQueryRepository = userQueryRepository;
        this.userQueryMapper = userQueryMapper;
    }

    @Transactional
    public UserQuerysEntity createUserQuery(UserQueryRequest userQueryRequest, ReportsEntity report) {
        try {
            UserQuerysEntity userQuery = userQueryMapper.toUserQuerysEntity(userQueryRequest, report);
            userQuery.setUser(report.getUser());
            return userQueryRepository.save(userQuery);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error creating user query", e);
        }
    }

    public List<UserQuerysEntity> findByReportId(Long reportId) {
        try {
            return userQueryRepository.findByReportId(reportId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving user queries by report id", e);
        }
    }
}