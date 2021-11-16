package com.mec.libapi.infrastructure.dao.impl.userModule;

import com.mec.libapi.domain.pojo.userModule.CanBook;
import com.mec.libapi.infrastructure.converter.userModule.CanBookConverter;
import com.mec.libapi.infrastructure.dao.core.AbstractFacadeImpl;
import com.mec.libapi.infrastructure.dao.facade.userModule.CanBookFacade;
import com.mec.libapi.infrastructure.dao.repository.userModule.CanBookRepository;
import com.mec.libapi.infrastructure.entity.userModule.CanBookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CanBookFacadeImpl extends AbstractFacadeImpl implements CanBookFacade {

    @Autowired
    private CanBookRepository canBookRepository;

    @Qualifier("CanBookInfConverter")
    @Autowired
    private CanBookConverter converter;

    @Override
    public CanBook save(CanBook canBook) {
        CanBookEntity canBookEntity = converter.to(canBook);
        CanBookEntity savedNCanBook = canBookRepository.save(canBookEntity);
        return converter.toPOJO(savedNCanBook);
    }

    @Override
    public CanBook findById(Long id) {
        Optional<CanBookEntity> canBookEntity = canBookRepository.findById(id);
        if (canBookEntity.isPresent()) {
            CanBook canBook = converter.toPOJO(canBookEntity.get());
            return canBook;
        }
        return null;
    }

    @Override
    public Stream<CanBook> findAll() {
        List<CanBookEntity> canBookEntities = canBookRepository.findAll();
        List<CanBook> canBookes = new ArrayList<>();
        canBookEntities.forEach(canBookEntity -> {
            canBookes.add(converter.toPOJO(canBookEntity));
        });
        return canBookes.stream();
    }

    @Override
    public void delete(Long id) {
        Optional<CanBookEntity> canBookEntity = canBookRepository.findById(id);
        canBookRepository.delete(canBookEntity.get());
    }
}
