package com.eafit.nodo.backamadeusgrupo3.contracts.request;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    private String name;
    private String email;
    private Date birthdate;
    private String DNI;
}
