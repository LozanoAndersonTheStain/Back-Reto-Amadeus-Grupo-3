package com.eafit.nodo.backamadeusgrupo3.contracts.responses;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DestinationInfoResponse {
    private String nombreDestino;
    private String pais;
    private String idioma;
    private String lugarImperdible;
    private String comidaTipica;
    private String img;
    private String continente;
}
