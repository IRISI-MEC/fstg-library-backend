package com.mec.libapi.infrastructure.dao.impl.bookModule;

import com.mec.libapi.domain.pojo.bookModule.Speciality;
import com.mec.libapi.infrastructure.converter.bookModule.SpecialityConverter;
import com.mec.libapi.infrastructure.dao.core.AbstractFacadeImpl;
import com.mec.libapi.infrastructure.dao.facade.bookModule.SpecialityFacade;
import com.mec.libapi.infrastructure.dao.repository.bookModule.SpecialityRepository;
import com.mec.libapi.infrastructure.entity.bookModule.SpecialityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;
import java.util.stream.Stream;

public class SpecialityFacadeImpl extends AbstractFacadeImpl implements SpecialityFacade {

    @Autowired
    private SpecialityRepository repository;
    @Autowired
    @Qualifier("SpecialityInfConverter")
    private SpecialityConverter specialityConverter;

    @Override
    public Speciality save(Speciality speciality) {
        return specialityConverter.toPojo(repository.save(specialityConverter.toEntity(speciality, false)), true);
    }

    @Override
    public Speciality findById(Long id) {
        Optional<SpecialityEntity> specialityEntity = repository.findById(id);
        return specialityEntity.map(entity -> specialityConverter.toPojo(entity, true)).orElse(null);
    }

    @Override
    public Stream<Speciality> findAll() {
        return repository.findAll().stream().map(entity -> specialityConverter.toPojo(entity, true));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Speciality findByLabel(String label) {
        Optional<SpecialityEntity> specialityEntity = repository.findByLabel(label);
        return specialityEntity.map(entity -> specialityConverter.toPojo(entity, true)).orElse(null);
    }
}
