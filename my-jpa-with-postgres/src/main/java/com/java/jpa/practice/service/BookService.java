package com.java.jpa.practice.service;

import com.java.jpa.practice.mapper.BookMapper;
import com.java.jpa.practice.model.Book;
import com.java.jpa.practice.model.BookRecord;
import com.java.jpa.practice.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public Optional<BookRecord> findById(Long id) {
        Optional<BookRecord> bookRecordOptional = Optional.empty();
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.map(bookMapper::mapToBookRecord).or(() -> bookRecordOptional);
    }

    public BookRecord createBook(BookRecord bookRecord) {
        Book book = bookMapper.mapToBook(bookRecord);
        book = bookRepository.save(book);
        log.debug("{} book saved.", book.getId());

        return bookMapper.mapToBookRecord(book);
    }

    public List<BookRecord> findAll() {
        List<Book> bookList = bookRepository.findAll();
        log.debug("{} books retrieved.", bookList.size());
        return bookList.stream().map(bookMapper::mapToBookRecord)
                .toList();
    }

//    public void deleteById(Long id) {
//        bookRepository.deleteById(id);
//    }
//
//    public List<BookRecord> findByTitle(String title) {
//        return bookRepository.findByTitle(title);
//    }
//
//    public List<BookRecord> findByPublishedDateAfter(LocalDate date) {
//        return bookRepository.findByPublishedDateAfter(date);
//    }
}
