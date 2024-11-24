package com.eafit.nodo.backamadeusgrupo3.repositories;

import com.eafit.nodo.backamadeusgrupo3.entities.ReportsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportsRepository extends JpaRepository<ReportsEntity, Long> {

    Optional<ReportsEntity> findById(Long id);

    ReportsEntity save(ReportsEntity reportsEntity);

    List<ReportsEntity> findAll();
}
