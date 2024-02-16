package com.java.practice;

import com.java.practice.model.BookRecord;
import com.java.practice.service.BookServiceReactiveClient;
import com.java.practice.util.GenerateBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@SpringBootApplication
@Slf4j
public class RestConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestConsumerApplication.class, args);
    }

    @Autowired
    BookServiceReactiveClient bookServiceReactiveClient;

    @Autowired
    GenerateBook generateBook;

    @Bean
    public CommandLineRunner callRestApi(WebClient webClient) throws Exception {
        return args -> {
//            BookRecord bookRecord = bookServiceReactiveClient.getBookById(6L);
//            log.info("book: {}", bookRecord);
//
//            Mono<List<BookRecord>> listMono = bookServiceReactiveClient.getAllBooks().collectList();
//            Objects.requireNonNull(listMono.block()).forEach(bookRecord1 -> {
//                log.info("book: {}", bookRecord1);
//            });

            Flux<BookRecord> fluxBookRecord = generateBook.createBooks(1200);
            fluxBookRecord.subscribe(bookRecord -> {
                log.info("book: {}", bookRecord);
                bookServiceReactiveClient.createBook(bookRecord);
            });
        };
    }
}
