package com.eafit.nodo.backamadeusgrupo3.contracts.responses;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanResponse {
    private Long id;
    private String name;
    private String description;
    private String destinationName;
    private String imageUrl;
    private List<FlightOptionResponse> flightOptions;
    private List<HotelOptionResponse> hotelOptions;
}