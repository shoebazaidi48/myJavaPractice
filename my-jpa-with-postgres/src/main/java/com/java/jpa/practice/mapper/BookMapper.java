package com.java.jpa.practice.mapper;

import com.java.jpa.practice.model.Book;
import com.java.jpa.practice.model.BookRecord;
import org.modelmapper.ModelMapper;
import org.modelmapper.record.RecordModule;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    private final ModelMapper modelMapper = new ModelMapper().registerModule(new RecordModule());

    public BookRecord mapToBookRecord(Book book) {
//        return modelMapper.map(book, BookRecord.class);
        return new BookRecord(book.getId(), book.getTitle(), book.getPrice(), book.getPublishDate());
    }

    public Book mapToBook(BookRecord bookRecord) {
        Book book = new Book();
        book.setId(bookRecord.id());
        book.setTitle(bookRecord.title());
        book.setPrice(bookRecord.price());
        book.setPublishDate(bookRecord.publishDate());

        return book;
    }

}
