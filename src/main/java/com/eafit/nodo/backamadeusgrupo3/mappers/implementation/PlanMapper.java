package com.eafit.nodo.backamadeusgrupo3.mappers.implementation;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.PlanRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.FlightOptionResponse;
import com.eafit.nodo.backamadeusgrupo3.entities.FlightOptionEntity;
import com.eafit.nodo.backamadeusgrupo3.entities.PlanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PlanMapper {

    private final FlightOptionMapper flightOptionMapper;

    @Autowired
    public PlanMapper(FlightOptionMapper flightOptionMapper) {
        this.flightOptionMapper = flightOptionMapper;
    }

    public PlanEntity toPlanEntity(PlanRequest planRequest) {
        if (planRequest == null) {
            return null;
        }

        return PlanEntity.builder()
                .name(planRequest.getName())
                .destinationName(planRequest.getDescription())
                .imageUrl(planRequest.getImageUrl())
                .flightOptions(planRequest.getFlightOptions().stream()
                        .map(flightOptionMapper::toFlightOption)
                        .collect(Collectors.toList()))
                .build();
    }

    public FlightOptionResponse toFlightOptionResponse(FlightOptionEntity flightOptionEntity) {
        if (flightOptionEntity == null) {
            return null;
        }

        return FlightOptionResponse.builder()
                .name(flightOptionEntity.getName())
                .description(flightOptionEntity.getDescription())
                .imageUrl(flightOptionEntity.getImageUrl())
                .url(flightOptionEntity.getUrl())
                .build();
    }
}
