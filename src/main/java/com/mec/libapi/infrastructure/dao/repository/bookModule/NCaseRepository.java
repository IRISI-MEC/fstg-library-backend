package com.mec.libapi.infrastructure.dao.repository.bookModule;

import com.mec.libapi.infrastructure.entity.bookModule.NCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NCaseRepository extends JpaRepository<NCaseEntity, Long> {

    Optional<NCaseEntity> findByCode(String code);
}
