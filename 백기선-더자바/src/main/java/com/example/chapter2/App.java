package com.example.chapter2;

public class App {
    public static void main(String[] args) {

        DefaultFoo foo = new DefaultFoo("Seongsu");
        foo.printName();                // Seongsu
        foo.printNameUpperCase();       // SEONGSU

        Foo.printAnything();            // static

    }
}
