package com.mec.libapi.application.converter.BookModule;

import com.mec.libapi.application.dto.bookModule.BookDto;
import com.mec.libapi.domain.pojo.bookModule.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("BookAppConverter")
public class BookConverter {

    @Autowired
    @Qualifier("InstanceAppConverter")
    InstanceConverter instanceConverter;
    @Autowired
    @Qualifier("SpecialityAppConverter")
    SpecialityConverter specialityConverter;

    public Book toPojo(BookDto bookDto) {
        Book book = new Book();
        book.setId(Long.parseLong(bookDto.getId()));
        book.setAuthor(bookDto.getAuthor());
        book.setDescription(bookDto.getDescription());
        book.setIsbn(bookDto.getIsbn());
        book.setTitle(bookDto.getTitle());
        book.setSpeciality(specialityConverter.toPojo(bookDto.getSpeciality()));
        return book;
    }

    public BookDto toDto(Book book, Boolean convertInstances, Boolean convertSpeciality) {

        BookDto bookDto = BookDto.builder()
                .id(book.getId().toString())
                .author(book.getAuthor())
                .description(book.getDescription())
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .build();

        if (convertSpeciality)
            bookDto.setSpeciality(specialityConverter.toDto(book.getSpeciality(), false));

        if (convertInstances)
            book.getInstances().forEach(instance -> bookDto.getInstances().add(instanceConverter.toDto(instance, false, true)));

        return bookDto;
    }

}
