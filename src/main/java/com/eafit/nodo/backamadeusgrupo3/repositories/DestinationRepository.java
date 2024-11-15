package com.eafit.nodo.backamadeusgrupo3.repositories;

import com.eafit.nodo.backamadeusgrupo3.entities.DestinationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository<DestinationEntity, Long> {
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM destino_info WHERE nombre_destino LIKE %:destino1% OR nombre_destino LIKE %:destino2%"
    )
    List<DestinationEntity> searchName(String destino1, String destino2);


}