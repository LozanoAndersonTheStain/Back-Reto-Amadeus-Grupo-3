package com.eafit.nodo.backamadeusgrupo3.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class DestinationInfoModel {
    private Long id;
    private String nombreDestino;
    private String pais;
    private String idioma;
    private String lugarImperdible;
    private String comidaTipica;
    private String img;
    private String continente;
}
