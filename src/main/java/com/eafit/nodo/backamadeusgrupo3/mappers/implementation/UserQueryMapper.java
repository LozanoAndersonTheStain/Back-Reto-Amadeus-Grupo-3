package com.eafit.nodo.backamadeusgrupo3.mappers.implementation;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.UserQueryRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.UserQueryResponse;
import com.eafit.nodo.backamadeusgrupo3.entities.UserQuerysEntity;
import com.eafit.nodo.backamadeusgrupo3.entities.ReportsEntity;
import com.eafit.nodo.backamadeusgrupo3.mappers.interfaces.UserMapper;
import com.eafit.nodo.backamadeusgrupo3.models.UserQuerysModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class UserQueryMapper {

    private final UserMapper userMapper;

    @Autowired
    public UserQueryMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserQuerysModel toUserQuerysModel(UserQuerysEntity userQuerysEntity) {
        if (userQuerysEntity == null) {
            return null;
        }

        return UserQuerysModel.builder()
                .id(userQuerysEntity.getId())
                .queryTime(userQuerysEntity.getQueryTime().toString())
                .environmentType(userQuerysEntity.getEnvironmentType())
                .climateType(userQuerysEntity.getClimateType())
                .accommodationType(userQuerysEntity.getAccommodationType())
                .activityType(userQuerysEntity.getActivityType())
                .stayDuration(userQuerysEntity.getStayDuration())
                .ageRange(userQuerysEntity.getAgeRange())
                .user(userMapper.toUser(userQuerysEntity.getUser()))
                .build();
    }

    public UserQuerysEntity toUserQuerysEntity(UserQuerysModel userQuerysModel, ReportsEntity report) {
        if (userQuerysModel == null) {
            return null;
        }

        return UserQuerysEntity.builder()
                .queryTime(Timestamp.valueOf(userQuerysModel.getQueryTime()))
                .environmentType(userQuerysModel.getEnvironmentType())
                .climateType(userQuerysModel.getClimateType())
                .accommodationType(userQuerysModel.getAccommodationType())
                .activityType(userQuerysModel.getActivityType())
                .stayDuration(userQuerysModel.getStayDuration())
                .ageRange(userQuerysModel.getAgeRange())
                .user(userMapper.toUserEntity(userQuerysModel.getUser()))
                .report(report)
                .build();
    }

    public UserQuerysEntity toUserQuerysEntity(UserQueryRequest userQueryRequest, ReportsEntity report) {
        if (userQueryRequest == null) {
            return null;
        }

        return UserQuerysEntity.builder()
                .queryTime(Timestamp.valueOf(userQueryRequest.getQueryTime()))
                .environmentType(userQueryRequest.getEnvironmentType())
                .climateType(userQueryRequest.getClimateType())
                .accommodationType(userQueryRequest.getAccommodationType())
                .activityType(userQueryRequest.getActivityType())
                .stayDuration(userQueryRequest.getStayDuration())
                .ageRange(userQueryRequest.getAgeRange())
                .report(report)
                .build();
    }

    public UserQueryResponse toUserQueryResponse(UserQuerysEntity userQuerysEntity) {
        if (userQuerysEntity == null) {
            return null;
        }

        return UserQueryResponse.builder()
                .queryTime(userQuerysEntity.getQueryTime().toString())
                .environmentType(userQuerysEntity.getEnvironmentType())
                .climateType(userQuerysEntity.getClimateType())
                .accommodationType(userQuerysEntity.getAccommodationType())
                .activityType(userQuerysEntity.getActivityType())
                .stayDuration(userQuerysEntity.getStayDuration())
                .ageRange(userQuerysEntity.getAgeRange())
                .build();
    }
}