package com.eafit.nodo.backamadeusgrupo3.entities;

import com.eafit.nodo.backamadeusgrupo3.models.RoleUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date birthdate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleUser role;
}
