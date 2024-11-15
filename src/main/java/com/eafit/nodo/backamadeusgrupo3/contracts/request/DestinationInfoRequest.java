package com.eafit.nodo.backamadeusgrupo3.contracts.request;

import com.eafit.nodo.backamadeusgrupo3.entities.DestinationInfoEntity;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DestinationInfoRequest {
    private String nombreDestino;
    private List<DestinationInfoEntity> destinoInfoEntities;
}