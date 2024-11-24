package com.eafit.nodo.backamadeusgrupo3.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "reports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ReportsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String reportTime;

    @Column(nullable = false)
    private String reportData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserQuerysEntity> userQueries;
}