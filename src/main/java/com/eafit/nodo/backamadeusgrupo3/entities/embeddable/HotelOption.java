package com.eafit.nodo.backamadeusgrupo3.entities.embeddable;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelOption {
    private String name;
    private String description;
    private String imageUrl;
    private String url;
}
