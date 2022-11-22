package chapter03;

import chapter03.util.Adder;

import java.util.function.Function;

public class Chapter03Section1 {

    public static void main(String[] args) {
        Function<Integer, Integer> myAdder = new Adder();
        int result = myAdder.apply(5);

        System.out.println("result = " + result);


        // 이름없는 함수
        Function<Integer, Integer> myAdder1 = x -> x + 10;
        int reuslt1 = myAdder1.apply(3);

        System.out.println("reuslt1 = " + reuslt1);

    }

}
