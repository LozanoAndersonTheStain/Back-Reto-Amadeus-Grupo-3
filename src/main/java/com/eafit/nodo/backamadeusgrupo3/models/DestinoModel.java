package com.eafit.nodo.backamadeusgrupo3.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class DestinoModel {
    private Long id;
    private String destino;
    private String climatica;
    private String actividad;
    private String alojamiento;
    private String viaje;
    private String edad;
}
