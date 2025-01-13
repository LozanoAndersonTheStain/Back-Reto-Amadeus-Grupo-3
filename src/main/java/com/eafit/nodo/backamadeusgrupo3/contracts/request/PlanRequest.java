package com.eafit.nodo.backamadeusgrupo3.contracts.request;

import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanRequest {
    @Size(max = 500, message = "Name must be at most 500 characters")
    private String name;

    @Size(max = 1000, message = "Description must be at most 1000 characters")
    private String description;

    @Size(max = 500, message = "Destination must be at most 500 characters")
    private String destinationName;

    @Size(max = 500, message = "Image URL must be at most 500 characters")
    private String imageUrl;

    private List<FlightOptionRequest> flightOptions;
    private  List<HotelOptionRequest> hotelOptions;
}