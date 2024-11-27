// FlightOptionMapper.java
package com.eafit.nodo.backamadeusgrupo3.mappers.implementation;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.FlightOptionRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.FlightOptionResponse;
import com.eafit.nodo.backamadeusgrupo3.entities.FlightOptionEntity;
import com.eafit.nodo.backamadeusgrupo3.entities.embeddable.FlightOption;
import org.springframework.stereotype.Component;

@Component
public class FlightOptionMapper {
    public FlightOption toFlightOption(FlightOptionRequest flightOptionRequest) {
        if (flightOptionRequest == null) {
            return null;
        }

        return FlightOption.builder()
                .name(flightOptionRequest.getName())
                .description(flightOptionRequest.getDescription())
                .imageUrl(flightOptionRequest.getImageUrl())
                .url(flightOptionRequest.getUrl())
                .build();
    }

    public FlightOptionRequest toFlightOptionRequest(FlightOptionEntity flightOptionEntity) {
        if (flightOptionEntity == null) {
            return null;
        }

        return FlightOptionRequest.builder()
                .name(flightOptionEntity.getName())
                .description(flightOptionEntity.getDescription())
                .imageUrl(flightOptionEntity.getImageUrl())
                .url(flightOptionEntity.getUrl())
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