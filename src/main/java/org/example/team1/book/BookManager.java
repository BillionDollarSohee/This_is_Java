package org.example.team1.book;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;


public class BookManager {
    private HashMap<Long, Book> bookList = new HashMap<>();
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private void bookCreate(Long ISBN, String bookName, BigDecimal bookPrice) {
        Book book = new Book(ISBN, bookName, bookPrice);
        bookList.put(ISBN,book);
        bookList.get(ISBN).toString();
    }

    private void getBook(Long ISBN) {
        if (bookList.containsKey(ISBN)) {
            bookList.get(ISBN).toString();
        }
    }

    private void getBookList() {
        System.out.println("도서 수 : " + bookList.size());

        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i).toString());
        }
    }

    private void delete(Long ISBN) {
        bookList.remove(ISBN);
        System.out.println("삭제하였습니다.");
    }

    public void Run() {

//        while (true) {
//            System.out.println("1:추가 2:삭제 3:검색 4:도서 목록 5:ISBN 목록 0:종료");
//            int menu = Integer.parseInt(br.readLine());
//
//            switch (menu) {
//
//                case 1 -> {
//                    System.out.printf("추가할 도서");
//                    long inputISBN = Long.parseLong(br.readLine());
//                    System.out.printf("도서 제목");
//                    String  inputBookName = br.readLine();
//                    System.out.printf("가격");
//                    BigDecimal inputBookPrice = br.readLine();
//                    bookCreate(inputISBN,inputBookName,inputBookPrice);
//                }
//
//                case 2 ->
//
//                case 3 ->
//
//                case 4 ->
//
//                case 5 ->
//
//                case 0 -> {
//                    System.out.println("종료합니다...");
//                    return;
//                }
//                default -> System.out.println("잘못된 메뉴 선택입니다.");
//
//            }
//
//        }

    }

}
