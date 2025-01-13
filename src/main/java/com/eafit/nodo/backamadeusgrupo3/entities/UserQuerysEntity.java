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
    private String environmentType;

    @Column(nullable = false)
    private String climateType;

    @Column(nullable = false)
    private String accommodationType;

    @Column(nullable = false)
    private String activityType;

    @Column(nullable = false)
    private String stayDuration;

    @Column(nullable = false)
    private String ageRange;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id", nullable = false)
    private ReportsEntity report;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}