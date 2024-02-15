package com.java.jpa.practice.config;

import com.java.jpa.practice.model.Book;
import com.java.jpa.practice.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Configuration
@Slf4j
class LoadBookDatabase {
    @Bean
    @ConditionalOnProperty(prefix = "app", name = "db.init.enabled", havingValue = "true")
    public CommandLineRunner initDatabase(BookRepository bookRepository) {
        return args -> {

            System.out.println("Initializing DB....");

            Book b1 = new Book("Book A",
                    BigDecimal.valueOf(9.99),
                    LocalDate.of(2023, 8, 31));
            Book b2 = new Book("Book B",
                    BigDecimal.valueOf(19.99),
                    LocalDate.of(2023, 7, 31));
            Book b3 = new Book("Book C",
                    BigDecimal.valueOf(29.99),
                    LocalDate.of(2023, 6, 10));
            Book b4 = new Book("Book D",
                    BigDecimal.valueOf(39.99),
                    LocalDate.of(2023, 5, 5));

            bookRepository.saveAll(List.of(b1, b2, b3, b4));

            System.out.println("Done Initializing DB....");
        };
    }
}
