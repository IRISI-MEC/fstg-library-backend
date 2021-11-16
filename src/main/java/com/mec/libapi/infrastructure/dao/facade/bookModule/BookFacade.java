package com.mec.libapi.infrastructure.dao.facade.bookModule;

import com.mec.libapi.domain.pojo.bookModule.Book;
import com.mec.libapi.domain.pojo.bookModule.Speciality;
import com.mec.libapi.infrastructure.dao.facade.AbstractFacade;

import java.util.List;
import java.util.stream.Stream;

public interface BookFacade extends AbstractFacade<Book, Long> {

    Stream<Book> saveAll(List<Book> books);
    Book findByIsbn(String isbn);
    Book findByTitleContains(String keyword);
    Stream<Book> findByAuthor(String author);
    Stream<Book> findBySpeciality(Speciality speciality);

}
