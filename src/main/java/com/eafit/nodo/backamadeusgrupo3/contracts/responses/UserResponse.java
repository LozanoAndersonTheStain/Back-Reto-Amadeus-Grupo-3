package com.eafit.nodo.backamadeusgrupo3.contracts.responses;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private String name;
    private String email;
    private Date birthdate;

    @Override
    public String toString() {
        return "UserResponse {" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
