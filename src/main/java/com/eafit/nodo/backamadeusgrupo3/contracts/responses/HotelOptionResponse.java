package com.eafit.nodo.backamadeusgrupo3.contracts.responses;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelOptionResponse {
    private String name;
    private String description;
    private String imageUrl;
    private String url;
}
