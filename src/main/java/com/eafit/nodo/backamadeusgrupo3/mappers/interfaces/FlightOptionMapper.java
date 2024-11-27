package com.eafit.nodo.backamadeusgrupo3.mappers.interfaces;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.FlightOptionRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.FlightOptionResponse;
import com.eafit.nodo.backamadeusgrupo3.entities.embeddable.FlightOption;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightOptionMapper {
    FlightOption toFlightOption(FlightOptionRequest flightOptionRequest);

    FlightOptionRequest toFlightOptionRequest(FlightOption flightOption);

    FlightOptionResponse toFlightOptionResponse(FlightOption flightOption);
}