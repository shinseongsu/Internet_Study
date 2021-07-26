package com.example.chapter2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class App2 {
    public static void main(String[] args) {

        List<String> name = new ArrayList<>();
        name.add("seongsu");
        name.add("Yejo");
        name.add("TODO");
        name.add("sehyun");

        for(String n : name) {
            System.out.println(n);
        }
        /*
        * seongsu
          Yejo
          TODO
          sehyun
        * */
        System.out.println();

        name.forEach(System.out::println);
        /*
        * seongsu
          Yejo
          TODO
          sehyun
        * */
        System.out.println();

        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while(spliterator.tryAdvance(System.out::println));
        /*
        * TODO
        * sehyun
        * */
        System.out.println("=====");

        while(spliterator1.tryAdvance(System.out::println));
        /*
         * seongsu
         * Yejo
         * */
        System.out.println();

        List<String> j = name.stream()
                        .map(String::toUpperCase)
                        .filter(s -> s.startsWith("S"))
                        .collect((Collectors.toList()));
        j.forEach(System.out::println);
        /*
         * SEONGSU
         * SEHYUN
         * */
        System.out.println("======");

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);
        /*
         * Yejo
         * TODO
         * seongsu
         * sehyun
         * */

    }
}
