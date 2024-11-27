package com.eafit.nodo.backamadeusgrupo3.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PlanModel {
    private Long id;
    private String name;
    private String description;
    private String destinationName;
    private String imageUrl;
}