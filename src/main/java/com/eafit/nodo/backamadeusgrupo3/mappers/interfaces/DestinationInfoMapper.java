package com.eafit.nodo.backamadeusgrupo3.mappers.interfaces;

import com.eafit.nodo.backamadeusgrupo3.contracts.responses.DestinationInfoResponse;
import com.eafit.nodo.backamadeusgrupo3.entities.DestinationInfoEntity;

public interface DestinationInfoMapper {
    DestinationInfoResponse toResponse(DestinationInfoEntity entity);
    DestinationInfoEntity toEntity(DestinationInfoResponse response);
}
