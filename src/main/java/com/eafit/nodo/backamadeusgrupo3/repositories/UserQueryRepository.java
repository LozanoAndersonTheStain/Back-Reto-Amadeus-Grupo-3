package com.eafit.nodo.backamadeusgrupo3.repositories;

import com.eafit.nodo.backamadeusgrupo3.entities.UserQuerysEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserQueryRepository extends JpaRepository<UserQuerysEntity, Long> {

    Optional<UserQuerysEntity> findById(Long id);

    UserQuerysEntity save(UserQuerysEntity userQuerysEntity);

    List<UserQuerysEntity> findAll();

    List<UserQuerysEntity> findByReportId(Long reportId);
}
