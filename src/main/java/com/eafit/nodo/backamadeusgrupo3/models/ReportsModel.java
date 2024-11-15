package com.eafit.nodo.backamadeusgrupo3.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ReportsModel {
    private  Long id;
    private String reportTime;
    private String reportData;
    private User user;
}
