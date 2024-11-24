package com.eafit.nodo.backamadeusgrupo3.contracts.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserQueryRequest {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private String queryTime;
    private String environmentType;
    private String climateType;
    private String accommodationType;
    private String activityType;
    private String stayDuration;
    private String ageRange;
}