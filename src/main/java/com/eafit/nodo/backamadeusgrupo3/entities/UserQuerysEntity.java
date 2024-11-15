package com.eafit.nodo.backamadeusgrupo3.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;


@Entity(name = "users_querys")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserQuerysEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Timestamp queryTime;

    @Column(nullable = false)
    private String environment_type;

    @Column(nullable = false)
    private String climate_type;

    @Column(nullable = false)
    private String accommodation_type;

    @Column(nullable = false)
    private String activity_type;

    @Column(nullable = false)
    private String stay_duration;

    @Column(nullable = false)
    private String age_range;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
