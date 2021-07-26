package com.example.chapter1;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Foo {
    public static void main(String[] args){

        // 익명 내부 클래스
        RunSomething runSomething1 = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("Hello");
            }
        };

        // 람다 표현식
        RunSomething runSomething2 = () -> System.out.println("Hello");
        runSomething2.doIt();   // Hello

        Function<Integer, Integer> plus10 = (i) -> i + 10;
        System.out.println(plus10.apply(1));    // 출력 : 11
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(2));    // 14     (  10 +  (i * 2))
        Function<Integer, Integer> plus10AndMutiply2 = plus10.andThen(multiply2);
        System.out.println(plus10AndMutiply2.apply(2));     // 24    ( 10 + i * 2 )

        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);  // 10

        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());    // 10

        Predicate<String> startsWithSeongsu = (s) -> s.startsWith("Seongsu");

    }
}
