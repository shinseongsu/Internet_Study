package com.example.chapter1;

@FunctionalInterface
public interface RunSomething {

    void doIt();

    static void pringName() {
        System.out.println("Seongsu");
    }

    default void printAge() {
        System.out.println("27");
    }

}
