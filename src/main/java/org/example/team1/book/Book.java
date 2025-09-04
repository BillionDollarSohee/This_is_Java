package org.example.team1.book;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Book {
    private Long ISBN;
    private String bookName;
    private BigDecimal bookPrice;

    Book(Long ISBN, String bookName, BigDecimal bookPrice) {
        this.ISBN = ISBN;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return "ISBN:" + ISBN +
                ", 이름:" + bookName +
                " 가격:" + bookPrice;
    }
}
