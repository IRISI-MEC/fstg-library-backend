package com.mec.libapi.infrastructure.dao.impl.bookModule;

import com.mec.libapi.domain.pojo.bookModule.Book;
import com.mec.libapi.domain.pojo.bookModule.Instance;
import com.mec.libapi.domain.pojo.bookModule.NCase;
import com.mec.libapi.infrastructure.converter.bookModule.BookConverter;
import com.mec.libapi.infrastructure.converter.bookModule.InstanceConverter;
import com.mec.libapi.infrastructure.converter.bookModule.NCaseConverter;
import com.mec.libapi.infrastructure.dao.facade.bookModule.InstanceFacade;
import com.mec.libapi.infrastructure.dao.repository.bookModule.InstanceRepository;
import com.mec.libapi.infrastructure.entity.bookModule.BookEntity;
import com.mec.libapi.infrastructure.entity.bookModule.InstanceEntity;
import com.mec.libapi.infrastructure.entity.bookModule.NCaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InstanceFacadeImpl implements InstanceFacade {

    @Autowired
    private InstanceRepository repository;
    @Autowired
    @Qualifier("InstanceInfConverter")
    private InstanceConverter instanceConverter;
    @Autowired
    @Qualifier("BookInfConverter")
    private BookConverter bookConverter;
    @Autowired
    @Qualifier("NCaseInfConverter")
    private NCaseConverter nCaseConverter;

    @Override
    public Instance save(Instance instance) {
        return instanceConverter.toPojo(repository.save(instanceConverter.toEntity(instance, true, true)), true, true);
    }

    @Override
    public Instance findById(Long id) {
        Optional<InstanceEntity> instanceEntity = repository.findById(id);
        return instanceEntity.map(entity -> instanceConverter.toPojo(entity, true, true)).orElse(null);
    }

    @Override
    public Stream<Instance> findAll() {
        return repository.findAll().stream().map(instanceEntity -> instanceConverter.toPojo(instanceEntity, true, true));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Stream<Instance> saveAll(List<Instance> instances) {
        Iterable<InstanceEntity> entities = instances.stream().map(instance -> instanceConverter.toEntity(instance, true, true)).collect(Collectors.toList());
        return repository.saveAllAndFlush(entities).stream().map(entity -> instanceConverter.toPojo(entity, true, true));
    }

    @Override
    public Instance findByQrCode(String qrcode) {
        Optional<InstanceEntity> instanceEntity = repository.findByQrCode(qrcode);
        return instanceEntity.map(entity -> instanceConverter.toPojo(entity, true, true)).orElse(null);
    }

    @Override
    public Instance findByInventoryNumber(Long inventoryNumber) {
        Optional<InstanceEntity> instanceEntity = repository.findByInventoryNumber(inventoryNumber);
        return instanceEntity.map(entity -> instanceConverter.toPojo(entity, true, true)).orElse(null);
    }

    @Override
    public Stream<Instance> findByEditor(String editor) {
        return repository.findByEditor(editor).map(instanceEntity -> instanceConverter.toPojo(instanceEntity, true, true));
    }

    @Override
    public Stream<Instance> findByEdition(String edition) {
        return repository.findByEdition(edition).map(instanceEntity -> instanceConverter.toPojo(instanceEntity, true, true));
    }

    @Override
    public Stream<Instance> findByPublishingDate(LocalDate date) {
        return repository.findByPublishingDate(date).map(instanceEntity -> instanceConverter.toPojo(instanceEntity, true, true));
    }

    @Override
    public Stream<Instance> findByLanguage(String language) {
        return repository.findByLanguage(language).map(instanceEntity -> instanceConverter.toPojo(instanceEntity, true, true));
    }

    @Override
    public Stream<Instance> findByBook(Book book) {
        BookEntity bookEntity = bookConverter.toEntity(book, false, false);
        return repository.findByBookEntity(bookEntity).map(entity -> instanceConverter.toPojo(entity, false, true));
    }

    @Override
    public Stream<Instance> findByNCase(NCase nCase) {
        NCaseEntity nCaseEntity = nCaseConverter.toEntity(nCase, false);
        return repository.findByNCaseEntity(nCaseEntity).map(entity -> instanceConverter.toPojo(entity, false, true));
    }
}
