package com.java.jpa.practice.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BookRecord( Long id,
         String title,
         BigDecimal price,
         LocalDate publishDate) {
}
