package com.java.practice.util;

import com.github.javafaker.Faker;
import com.java.practice.model.BookRecord;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@Log4j2
public class GenerateBook {

    private final Faker faker = Faker.instance(new Locale("en-US"));

    public BookRecord createBook() {
        return new BookRecord(System.currentTimeMillis(), faker.book().title(),
                generateRandomBigDecimalFromRange(
                        BigDecimal.valueOf(-1.21).setScale(2, BigDecimal.ROUND_HALF_UP),
                        BigDecimal.valueOf(21.28).setScale(2, BigDecimal.ROUND_HALF_UP)),
               LocalDate.now());
    }

    public Flux<BookRecord> createBooks(int numberOfBooks){
        List<BookRecord> bookRecordList = new ArrayList<>(numberOfBooks);
        for (int i = 0; i < numberOfBooks; i++) {
            bookRecordList.add(createBook());
        }

        return Flux.fromIterable(bookRecordList);
    }

    private BigDecimal generateRandomBigDecimalFromRange(BigDecimal min, BigDecimal max) {
        BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
