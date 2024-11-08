package com.eafit.nodo.backamadeusgrupo3.models;

import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String email;
    private Date birthdate;
    private String password;
    private String DNI;
}