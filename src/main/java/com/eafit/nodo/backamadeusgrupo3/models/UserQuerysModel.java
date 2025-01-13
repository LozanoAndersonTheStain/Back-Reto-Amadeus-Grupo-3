package com.eafit.nodo.backamadeusgrupo3.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserQuerysModel {
    private Long id;
    private String query;
    private String queryTime;
    private String environmentType;
    private String climateType;
    private String accommodationType;
    private String activityType;
    private String stayDuration;
    private String ageRange;
    private User user;
}