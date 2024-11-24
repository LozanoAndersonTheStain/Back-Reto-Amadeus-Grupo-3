package com.eafit.nodo.backamadeusgrupo3.contracts.responses;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserQueryResponse {
    private Long id;
    private String queryTime;
    private String environmentType;
    private String climateType;
    private String accommodationType;
    private String activityType;
    private String stayDuration;
    private String ageRange;
}