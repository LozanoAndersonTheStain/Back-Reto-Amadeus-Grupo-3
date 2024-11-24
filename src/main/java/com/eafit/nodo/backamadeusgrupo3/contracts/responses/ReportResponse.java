package com.eafit.nodo.backamadeusgrupo3.contracts.responses;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ReportResponse {
    private Long id;
    private String reportTime;
    private String reportData;
    private UserResponse user;
    private List<UserQueryResponse> userQueries;
}