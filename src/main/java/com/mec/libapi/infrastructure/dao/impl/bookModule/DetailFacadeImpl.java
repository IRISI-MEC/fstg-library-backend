package com.mec.libapi.infrastructure.dao.impl.bookModule;

import com.mec.libapi.domain.pojo.bookModule.Detail;
import com.mec.libapi.infrastructure.converter.bookModule.DetailConverter;
import com.mec.libapi.infrastructure.dao.core.AbstractFacadeImpl;
import com.mec.libapi.infrastructure.dao.facade.bookModule.DetailFacade;
import com.mec.libapi.infrastructure.dao.repository.bookModule.DetailRepository;
import com.mec.libapi.infrastructure.entity.bookModule.DetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;
import java.util.stream.Stream;

public class DetailFacadeImpl extends AbstractFacadeImpl implements DetailFacade {

    @Autowired
    private DetailRepository repository;
    @Autowired
    @Qualifier("DetailInfConverter")
    private DetailConverter detailConverter;

    @Override
    public Detail save(Detail detail) {
        return detailConverter.toPojo(repository.save(detailConverter.toEntity(detail)));
    }

    @Override
    public Detail findById(Long id) {
        Optional<DetailEntity> detailEntity = repository.findById(id);
        return detailEntity.map(entity -> detailConverter.toPojo(entity)).orElse(null);
    }

    @Override
    public Stream<Detail> findAll() {
        return repository.findAll().stream().map(entity -> detailConverter.toPojo(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Detail findByAllAttributes(String butType, String condition, String dSlip, String provider) {
        Optional<DetailEntity> detailEntity = repository.findByBuyTypeAndStateAndDeliverySlipAndProvider(butType, condition, dSlip, provider);
        return detailEntity.map(entity -> detailConverter.toPojo(entity)).orElse(null);
    }
}
