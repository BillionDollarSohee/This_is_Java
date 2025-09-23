package org.basic.tesk.book;

import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
public class Book implements Serializable {
//    private static final long serialVersionUID = 1l; //시리얼 라이즈 버전 관리를 직접 하고 싶으면
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
