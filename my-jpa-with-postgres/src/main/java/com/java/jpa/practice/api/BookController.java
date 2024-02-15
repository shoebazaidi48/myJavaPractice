package com.java.jpa.practice.api;

import com.java.jpa.practice.model.BookRecord;
import com.java.jpa.practice.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/api/book")
@Slf4j
class BookController {

    private final BookService bookService;

    BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(path = "/create", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<BookRecord> createBook(@RequestBody BookRecord book) {
        BookRecord bookRecord = bookService.createBook(book);
        return ResponseEntity.created(toLocationUri(bookRecord.id()))
                .body(bookRecord);
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BookRecord> findBookById(@PathVariable Long id) {
        return bookService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    log.debug("Attempt to retrieve failed because book not found.");
                    return notFound().build();
                });
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<BookRecord> findAllBooks() {
        return bookService.findAll();
    }

    private URI toLocationUri(Object id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
