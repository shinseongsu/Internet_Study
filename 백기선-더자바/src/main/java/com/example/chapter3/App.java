package com.example.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("seongsu");
        names.add("Yejo");
        names.add("TODO");
        names.add("sehyun");

        Stream<String> stream = names.stream()
                .map(String::toUpperCase);
        List<String> collect = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        List<String> parallelStream = names.parallelStream()
                .map((s) -> {
                    System.out.println(s + " " + Thread.currentThread().getName()); // seongsu ForkJoinPool.commonPool-worker-7
                                                                                    // sehyun ForkJoinPool.commonPool-worker-5
                                                                                    // Yejo ForkJoinPool.commonPool-worker-3
                                                                                    // TODO main
                    return s.toUpperCase();
                }).collect(Collectors.toList());
         parallelStream.forEach(System.out::println);
         /*
         * SEONGSU
         * YEJO
         * TODO
         * SEHYUN
         * */
    }
}
