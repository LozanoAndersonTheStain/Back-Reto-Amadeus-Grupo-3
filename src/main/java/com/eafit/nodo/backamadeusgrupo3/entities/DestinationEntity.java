package com.eafit.nodo.backamadeusgrupo3.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Getter
@Setter
@Entity(name = "destino")
public class DestinationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destino;
    private String climatica;
    private String actividad;
    private String alojamiento;
    private String viaje;
    private String edad;

    @OneToOne(mappedBy = "destino", cascade = CascadeType.ALL)
    private DestinationInfoEntity destinoInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
