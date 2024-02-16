package com.java.practice.service;

import com.java.practice.model.BookRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
@Slf4j
public class BookServiceReactiveClient {
    private final WebClient bookWebClient;

    public BookServiceReactiveClient(WebClient bookWebClient) {
        this.bookWebClient = bookWebClient;
    }

    public BookRecord getBookById(Long id) {
        return bookWebClient.get()
                .uri("/" + id)
                .retrieve()
                .bodyToMono(BookRecord.class)
                        .block();
    }

    public Flux<BookRecord> getAllBooks() {
        return bookWebClient.get()
                .retrieve()
                .bodyToFlux(BookRecord.class);
    }

    public void createBook(BookRecord bookRecord) {

        Object responseBookRecord = bookWebClient.post()
                .uri("/create")
                .header("cache-control", "no-cache")
                .header("content-type", "application/json")
                .body(BodyInserters.fromObject(bookRecord))
                .retrieve().bodyToMono(BookRecord.class).block();

        log.info("responseBookRecord: {}", responseBookRecord);
    }
}
