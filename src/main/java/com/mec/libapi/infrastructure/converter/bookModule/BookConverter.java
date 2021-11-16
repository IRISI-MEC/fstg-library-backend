package com.mec.libapi.infrastructure.converter.bookModule;

import com.mec.libapi.domain.pojo.bookModule.Book;
import com.mec.libapi.infrastructure.entity.bookModule.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("BookInfConverter")
public class BookConverter {

    @Autowired
    @Qualifier("InstanceInfConverter")
    InstanceConverter instanceConverter;

    @Autowired
    @Qualifier("SpecialityInfConverter")
    SpecialityConverter specialityConverter;


    public BookEntity toEntity(Book book, Boolean convertInstances, Boolean convertSpeciality) {
        BookEntity bookEntity = BookEntity.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .description(book.getDescription())
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .build();

        if (convertInstances)
            book.getInstances().forEach(instance -> bookEntity.getInstanceEntities().add(instanceConverter.toEntity(instance, false, false)));

        if (convertSpeciality)
            bookEntity.setSpecialityEntity(specialityConverter.toEntity(book.getSpeciality(), false));

        return bookEntity;
    }

    public Book toPojo(BookEntity bookEntity, Boolean convertInstances, Boolean convertSpeciality) {

        Book book = new Book();
        book.setId(bookEntity.getId());
        book.setAuthor(bookEntity.getAuthor());
        book.setDescription(bookEntity.getDescription());
        book.setIsbn(bookEntity.getIsbn());
        book.setTitle(bookEntity.getTitle());

        if (convertInstances)
            bookEntity.getInstanceEntities().forEach(instanceEntity -> book.getInstances().add(instanceConverter.toPojo(instanceEntity, false, false)));

        if (convertSpeciality)
            book.setSpeciality(specialityConverter.toPojo(bookEntity.getSpecialityEntity(), true));

        return book;
    }

}
