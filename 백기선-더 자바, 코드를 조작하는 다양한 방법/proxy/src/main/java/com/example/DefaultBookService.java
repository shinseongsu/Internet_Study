package com.example;

public class DefaultBookService implements BookService {

    @Override
    public void rent(Book book) {
        System.out.println(book.getTitle());
    }
}
