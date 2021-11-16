package com.mec.libapi.infrastructure.dao.impl.bookModule;

import com.mec.libapi.domain.pojo.bookModule.Book;
import com.mec.libapi.domain.pojo.bookModule.Speciality;
import com.mec.libapi.infrastructure.converter.bookModule.BookConverter;
import com.mec.libapi.infrastructure.converter.bookModule.SpecialityConverter;
import com.mec.libapi.infrastructure.dao.core.AbstractFacadeImpl;
import com.mec.libapi.infrastructure.dao.facade.bookModule.BookFacade;
import com.mec.libapi.infrastructure.dao.repository.bookModule.BookRepository;
import com.mec.libapi.infrastructure.entity.bookModule.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookFacadeImpl extends AbstractFacadeImpl implements BookFacade {

    @Autowired
    private BookRepository repository;
    @Autowired
    @Qualifier("BookInfConverter")
    private BookConverter bookConverter;
    @Autowired
    @Qualifier("SpecialityInfConverter")
    private SpecialityConverter specialityConverter;


    @Override
    public Book save(Book book) {
        return bookConverter.toPojo(bookConverter.toEntity(book, false, true), true, true);
    }

    @Override
    public Book findById(Long id) {
        Optional<BookEntity> bookEntity = repository.findById(id);
        return bookEntity.map(entity -> bookConverter.toPojo(entity, true, true)).orElse(null);
    }

    @Override
    public Stream<Book> findAll() {
        return repository.findAll().stream().map(bookEntity -> bookConverter.toPojo(bookEntity, true, true));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Stream<Book> saveAll(List<Book> books) {
        Iterable<BookEntity> bookEntities = books.stream().map(book -> bookConverter.toEntity(book, false, true)).collect(Collectors.toList());
        return repository.saveAllAndFlush(bookEntities).stream().map(entity -> bookConverter.toPojo(entity, false, true));
    }

    @Override
    public Book findByIsbn(String isbn) {
        Optional<BookEntity> bookEntity = repository.findByIsbn(isbn);
        return bookEntity.map(entity -> bookConverter.toPojo(entity, true, true)).orElse(null);
    }

    @Override
    public Book findByTitleContains(String keyword) {
        Optional<BookEntity> bookEntity = repository.findByTitleContains(keyword);
        return bookEntity.map(entity -> bookConverter.toPojo(entity, true, true)).orElse(null);
    }

    @Override
    public Stream<Book> findByAuthor(String author) {
        Stream<BookEntity> bookEntities = repository.findByAuthor(author);
        return bookEntities.map(entity -> bookConverter.toPojo(entity, true, true));
    }

    @Override
    public Stream<Book> findBySpeciality(Speciality speciality) {
        Stream<BookEntity> bookEntities = repository.findBySpecialityEntity(specialityConverter.toEntity(speciality, false));
        return bookEntities.map(entity -> bookConverter.toPojo(entity, true, true));
    }
}
