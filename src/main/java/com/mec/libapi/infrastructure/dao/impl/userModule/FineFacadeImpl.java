package com.mec.libapi.infrastructure.dao.impl.userModule;

import com.mec.libapi.domain.pojo.userModule.Fine;
import com.mec.libapi.domain.pojo.userModule.Fine;
import com.mec.libapi.infrastructure.converter.userModule.FineConverter;
import com.mec.libapi.infrastructure.dao.core.AbstractFacadeImpl;
import com.mec.libapi.infrastructure.dao.facade.userModule.FineFacade;
import com.mec.libapi.infrastructure.dao.repository.userModule.FineRepository;
import com.mec.libapi.infrastructure.entity.userModule.FineEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class FineFacadeImpl extends AbstractFacadeImpl implements FineFacade {

    @Autowired
    private FineRepository fineRepository;

    @Qualifier("FineInfConverter")
    @Autowired
    private FineConverter converter;

    @Override
    public Fine save(Fine fine) {
        FineEntity fineEntity = converter.to(fine);
        FineEntity savedNFine = fineRepository.save(fineEntity);
        return converter.toPOJO(savedNFine);
    }

    @Override
    public Fine findById(Long id) {
        Optional<FineEntity> fineEntity = fineRepository.findById(id);
        if (fineEntity.isPresent()) {
            Fine fine = converter.toPOJO(fineEntity.get());
            return fine;
        }
        return null;
    }

    @Override
    public Stream<Fine> findAll() {
        List<FineEntity> fineEntities = fineRepository.findAll();
        List<Fine> finees = new ArrayList<>();
        fineEntities.forEach(fineEntity -> {
            finees.add(converter.toPOJO(fineEntity));
        });
        return finees.stream();
    }

    @Override
    public void delete(Long id) {
        Optional<FineEntity> fineEntity = fineRepository.findById(id);
        fineRepository.delete(fineEntity.get());
    }
}
