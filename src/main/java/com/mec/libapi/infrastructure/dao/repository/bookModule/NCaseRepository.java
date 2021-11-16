package com.mec.libapi.infrastructure.dao.repository.bookModule;

import com.mec.libapi.infrastructure.entity.bookModule.NumCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NCaseRepository extends JpaRepository<NumCaseEntity, Long> {

    Optional<NumCaseEntity> findByCode(String code);
}
