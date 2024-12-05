package com.eafit.nodo.backamadeusgrupo3.contracts.responses;

import com.eafit.nodo.backamadeusgrupo3.models.RoleUser;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private RoleUser role;

    @Override
    public String toString() {
        return "UserResponse {" +
                "id=" + id +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
