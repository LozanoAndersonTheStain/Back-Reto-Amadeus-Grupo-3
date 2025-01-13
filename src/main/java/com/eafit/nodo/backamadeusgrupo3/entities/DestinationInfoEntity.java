package com.eafit.nodo.backamadeusgrupo3.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Getter
@Setter
@Entity(name = "destino_info")
public class DestinationInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    private String nombreDestino;
    private String pais;
    private String idioma;
    private String lugarImperdible;
    private String comidaTipica;
    private String img;
    private String continente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destino_id")
    private DestinationEntity destino;
}
