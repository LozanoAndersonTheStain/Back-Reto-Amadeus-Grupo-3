package com.eafit.nodo.backamadeusgrupo3.mappers.interfaces;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.PlanRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.PlanResponse;
import com.eafit.nodo.backamadeusgrupo3.entities.PlanEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {FlightOptionMapper.class, DestinationInfoMapper.class})
public interface PlanMapper {

    @Mapping(source = "flightOptions", target = "flightOptions")
    @Mapping(source = "hotelOptions", target = "hotelOptions")
    @Mapping(source = "destinationName", target = "destinationName")
    PlanEntity toPlanEntity(PlanRequest planRequest);

    @Mapping(source = "destinationName", target = "destinationName")
    PlanResponse toPlanResponse(PlanEntity planEntity);
}