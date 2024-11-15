package com.eafit.nodo.backamadeusgrupo3.contracts.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DestinationRequest {
    private String destino;
    private String climatica;
    private String actividad;
    private String alojamiento;
    private String viaje;
    private String edad;
}