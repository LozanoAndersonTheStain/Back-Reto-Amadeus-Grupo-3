package com.eafit.nodo.backamadeusgrupo3.repositories;

import com.eafit.nodo.backamadeusgrupo3.entities.DestinationInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationInfoRepository extends JpaRepository<DestinationInfoEntity, Long> {

    DestinationInfoEntity saveAndFlush(DestinationInfoEntity destinoInfo);
}
