package com.eafit.nodo.backamadeusgrupo3.repositories;

import com.eafit.nodo.backamadeusgrupo3.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByNameAndEmail(String name, String email);
}