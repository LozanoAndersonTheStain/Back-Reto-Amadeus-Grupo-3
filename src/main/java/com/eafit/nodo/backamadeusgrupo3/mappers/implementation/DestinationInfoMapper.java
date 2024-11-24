package com.eafit.nodo.backamadeusgrupo3.mappers.implementation;

import com.eafit.nodo.backamadeusgrupo3.contracts.responses.DestinationInfoResponse;
import com.eafit.nodo.backamadeusgrupo3.entities.DestinationInfoEntity;
import com.eafit.nodo.backamadeusgrupo3.models.DestinationInfoModel;

public class DestinationInfoMapper {

    public static DestinationInfoResponse toResponse(DestinationInfoEntity entity) {
        return DestinationInfoResponse.builder()
                .nombreDestino(entity.getNombreDestino())
                .pais(entity.getPais())
                .idioma(entity.getIdioma())
                .lugarImperdible(entity.getLugarImperdible())
                .comidaTipica(entity.getComidaTipica())
                .img(entity.getImg())
                .continente(entity.getContinente())
                .build();
    }

    public static DestinationInfoEntity toEntity(DestinationInfoModel model) {
        return DestinationInfoEntity.builder()
                .id(model.getId())
                .nombreDestino(model.getNombreDestino())
                .pais(model.getPais())
                .idioma(model.getIdioma())
                .lugarImperdible(model.getLugarImperdible())
                .comidaTipica(model.getComidaTipica())
                .img(model.getImg())
                .continente(model.getContinente())
                .build();
    }
}