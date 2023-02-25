package com.example.chapter01;

import java.util.Arrays;
import java.util.List;

public class DeclarativePrograming {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 21, 10, 8, 11);

        int sum = numbers.stream()
                .filter(number -> number > 6 && (number % 2 != 0))
                .mapToInt(number -> number)
                .sum();

        System.out.println("# 선언형 프로그래밍 사용 : " + sum);
    }
}