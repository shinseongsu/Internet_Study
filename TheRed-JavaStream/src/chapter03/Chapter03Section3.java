package chapter03;

import chapter03.util.TriFunction;

public class Chapter03Section3 {
    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> addThreeNumbers = (x, y, z) -> x + y + z;

        int result = addThreeNumbers.apply(3, 2, 5);
        System.out.println("result = " + result);
    }
}
