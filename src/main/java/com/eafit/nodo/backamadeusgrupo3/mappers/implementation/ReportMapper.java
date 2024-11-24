package com.eafit.nodo.backamadeusgrupo3.mappers.implementation;

import com.eafit.nodo.backamadeusgrupo3.contracts.responses.ReportResponse;
import com.eafit.nodo.backamadeusgrupo3.entities.ReportsEntity;
import com.eafit.nodo.backamadeusgrupo3.mappers.interfaces.UserMapper;
import com.eafit.nodo.backamadeusgrupo3.mappers.interfaces.UserQuerysMapper;
import com.eafit.nodo.backamadeusgrupo3.models.ReportsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component()
public class ReportMapper {

    private final UserMapper userMapper;
    private final UserQuerysMapper userQuerysMapper;

    @Autowired
    public ReportMapper(UserMapper userMapper, UserQuerysMapper userQuerysMapper) {
        this.userMapper = userMapper;
        this.userQuerysMapper = userQuerysMapper;
    }

    public ReportResponse toReportResponse(ReportsEntity reportsEntity) {
        if (reportsEntity == null) {
            return null;
        }

        return ReportResponse.builder()
                .id(reportsEntity.getId())
                .reportTime(reportsEntity.getReportTime())
                .reportData(reportsEntity.getReportData())
                .user(userMapper.toUserResponse(reportsEntity.getUser()))
                .userQueries(reportsEntity.getUserQueries().stream()
                        .map(userQuerysMapper::toUserQueryResponse)
                        .collect(Collectors.toList()))
                .build();
    }
}