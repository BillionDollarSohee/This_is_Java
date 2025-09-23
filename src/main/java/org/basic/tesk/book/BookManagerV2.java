package org.basic.tesk.book;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class BookManagerV2 {
    private HashMap<Long, Book> book_dic = new HashMap<>();
    private Scanner scan = new Scanner(System.in);

    public Book createBook() {
        System.out.print("추가할 도서 ISBN(Long): ");
        Long isbn = scan.nextLong();
        scan.nextLine();

        if (book_dic.containsKey(isbn)) {
            System.out.println("이미 존재하는 ISBN입니다.");
            return null;
        }

        System.out.print("도서 제목: ");
        String title = scan.nextLine();

        System.out.print("가격(BigDecimal): ");
        BigDecimal price = scan.nextBigDecimal();
        scan.nextLine();

        Book book = new Book(isbn, title, price);
        book_dic.put(isbn, book);

        System.out.println(book.toString() + " 생성하였습니다.");
        return book;
    }
}
