package com.eafit.nodo.backamadeusgrupo3.models;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ReportsModel {
    private Long id;
    private String name;
    private String description;
    private String reportTime;
    private String reportData;
    private User user;
    private List<UserQuerysModel> userQueries;
}