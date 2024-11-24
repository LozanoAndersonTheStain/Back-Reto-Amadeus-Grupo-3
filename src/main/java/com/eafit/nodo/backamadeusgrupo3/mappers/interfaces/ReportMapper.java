package com.eafit.nodo.backamadeusgrupo3.mappers.interfaces;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.ReportsRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.ReportResponse;
import com.eafit.nodo.backamadeusgrupo3.entities.ReportsEntity;
import com.eafit.nodo.backamadeusgrupo3.models.ReportsModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = UserQuerysMapper.class)
public interface ReportMapper {

    ReportsEntity toReportsEntity(ReportsModel reportModel);

    ReportsModel toReportsModel(ReportsEntity reportsEntity);

    ReportsModel toReportsModel(ReportsRequest reportRequest);

    @Mapping(source = "userQueries", target = "userQueries")
    ReportResponse toReportResponse(ReportsEntity reportsEntity);
}