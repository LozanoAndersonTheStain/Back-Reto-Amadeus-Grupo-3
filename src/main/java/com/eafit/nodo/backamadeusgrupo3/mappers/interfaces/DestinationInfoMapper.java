package com.eafit.nodo.backamadeusgrupo3.mappers.interfaces;

import com.eafit.nodo.backamadeusgrupo3.contracts.responses.DestinationInfoResponse;
import com.eafit.nodo.backamadeusgrupo3.entities.DestinationInfoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DestinationInfoMapper {
    DestinationInfoResponse toResponse(DestinationInfoEntity entity);
    DestinationInfoEntity toEntity(DestinationInfoResponse response);

    @Mapping(target = "nombreDestino", source = "destination")
    DestinationInfoEntity toDestinationInfoEntity(String destination);

    default String map(DestinationInfoEntity value) {
        return value != null ? value.getNombreDestino() : null;
    }
}
