package com.eafit.nodo.backamadeusgrupo3.repositories;

import com.eafit.nodo.backamadeusgrupo3.entities.DestinationInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationInfoRepository extends JpaRepository<DestinationInfoEntity, Long> {

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM destino_info WHERE nombre_destino LIKE %:destination1% OR nombre_destino LIKE %:destination2%"
    )
    List<DestinationInfoEntity> getByName(String destination1, String destination2);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM destino_info WHERE id = :id"
    )
    List<DestinationInfoEntity> getById(int id);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM destino_info"
    )
    List<DestinationInfoEntity> index();

    List<DestinationInfoEntity> findAll();

    @Query(
            nativeQuery = true,
            value = "SELECT COUNT(*) > 0 FROM destino_info WHERE nombre_destino = :nombreDestino"
    )
    boolean existByDestination(String nombreDestino);
}