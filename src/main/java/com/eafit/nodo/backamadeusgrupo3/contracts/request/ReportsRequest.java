package com.eafit.nodo.backamadeusgrupo3.contracts.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportsRequest {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private String reportTime;
    private String reportData;
    private Long userId;
    private List<UserQueryRequest> userQueries;
}