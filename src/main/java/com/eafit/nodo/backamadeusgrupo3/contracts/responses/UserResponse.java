package com.eafit.nodo.backamadeusgrupo3.contracts.responses;

import com.eafit.nodo.backamadeusgrupo3.models.RoleUser;
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
    private RoleUser role;

    @Override
    public String toString() {
        return "UserResponse {" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                ", role='" + role + '\'' +
                '}';
    }
}
