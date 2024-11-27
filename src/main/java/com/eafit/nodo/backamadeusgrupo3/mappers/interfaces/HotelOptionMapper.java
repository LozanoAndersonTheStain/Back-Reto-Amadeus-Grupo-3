package com.eafit.nodo.backamadeusgrupo3.mappers.interfaces;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.HotelOptionRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.HotelOptionResponse;
import com.eafit.nodo.backamadeusgrupo3.entities.embeddable.HotelOption;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelOptionMapper {
    HotelOption toHotelOption(HotelOptionRequest hotelOptionRequest);

    HotelOptionRequest toHotelOptionRequest(HotelOption hotelOption);

    HotelOptionResponse toHotelOptionResponse(HotelOption hotelOption);
}