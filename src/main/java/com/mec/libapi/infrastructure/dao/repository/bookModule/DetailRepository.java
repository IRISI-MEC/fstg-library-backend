package com.mec.libapi.infrastructure.dao.repository.bookModule;

import com.mec.libapi.infrastructure.entity.bookModule.DetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetailRepository extends JpaRepository<DetailEntity, Long> {

    Optional<DetailEntity> findByBuyTypeAndConditionAndDeliverySlipAndProvider(String butType, String condition, String dSlip, String provider);

}
