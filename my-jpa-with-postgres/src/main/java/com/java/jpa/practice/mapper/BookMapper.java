package com.java.jpa.practice.mapper;

import com.java.jpa.practice.model.Book;
import com.java.jpa.practice.model.BookRecord;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookRecord mapToBookRecord(Book book) {
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
