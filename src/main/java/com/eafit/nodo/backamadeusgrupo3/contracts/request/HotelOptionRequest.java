package com.eafit.nodo.backamadeusgrupo3.contracts.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelOptionRequest {
    private String name;
    private String description;
    private String imageUrl;
    private String url;
}
