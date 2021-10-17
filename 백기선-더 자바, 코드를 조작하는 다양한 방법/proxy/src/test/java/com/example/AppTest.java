package com.example;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class AppTest {

    @Test
    public void proxy() {
        BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(),
                new Class[] { BookService.class }, (proxy, method, args) -> {
                    BookService service = new DefaultBookService();
                    System.out.println("AAAA");
                    Object invoke = method.invoke(service, args);
                    System.out.println("BBBB");
                    return invoke;
                });
        Book book = new Book("Demian", "Hello Demian", "Hermann Hesse");

        bookService.rent(book);
    }
}
