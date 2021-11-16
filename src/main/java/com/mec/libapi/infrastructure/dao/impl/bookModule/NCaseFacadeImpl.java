package com.mec.libapi.infrastructure.dao.impl.bookModule;

import com.mec.libapi.domain.pojo.bookModule.NCase;
import com.mec.libapi.infrastructure.converter.bookModule.NCaseConverter;
import com.mec.libapi.infrastructure.dao.facade.bookModule.NCaseFacade;
import com.mec.libapi.infrastructure.dao.repository.bookModule.NCaseRepository;
import com.mec.libapi.infrastructure.entity.bookModule.NCaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;
import java.util.stream.Stream;

public class NCaseFacadeImpl implements NCaseFacade {

    @Autowired
    private NCaseRepository repository;
    @Autowired
    @Qualifier("NCaseInfConverter")
    private NCaseConverter nCaseConverter;

    @Override
    public NCase save(NCase nCase) {
        return nCaseConverter.toPojo(repository.save(nCaseConverter.toEntity(nCase, false)), true);
    }

    @Override
    public NCase findById(Long id) {
        Optional<NCaseEntity> nCaseEntity = repository.findById(id);
        return nCaseEntity.map(entity -> nCaseConverter.toPojo(entity, true)).orElse(null);
    }

    @Override
    public Stream<NCase> findAll() {
        return repository.findAll().stream().map(nCaseEntity -> nCaseConverter.toPojo(nCaseEntity, true));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public NCase findByCode(String code) {
        Optional<NCaseEntity> nCaseEntity = repository.findByCode(code);
        return nCaseEntity.map(entity -> nCaseConverter.toPojo(entity, true)).orElse(null);
    }
}
