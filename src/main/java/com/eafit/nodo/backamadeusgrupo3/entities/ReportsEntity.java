package com.eafit.nodo.backamadeusgrupo3.entities;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

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
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
