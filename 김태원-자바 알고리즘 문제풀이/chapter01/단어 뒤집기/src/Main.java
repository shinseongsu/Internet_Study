import java.util.Scanner;

/**
 * 단어 뒤집기
 *
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
 *
 * 입력예시
 * ---------
 * 3
 * good
 * Time
 * Big
 *
 * 출력예시
 * ---------
 * doog
 * emiT
 * giB
 *
 *
 */
public class Main {

    public void solution(String[] input) {

        // 방법1
        /*for(String s : input) {
            String temp = new StringBuilder(s).reverse().toString();
            System.out.println(temp);
        }*/

        // 방법2
        for(String s : input) {
            char[] arr = s.toCharArray();
            int left = 0;
            int right = s.length() - 1;
            while( left < right ) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            System.out.println(String.valueOf(arr));
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] input = new String[N];
        for(int index = 0 ; index < input.length ; index = index + 1) {
            input[index] = scanner.next();
        }
        scanner.close();

        Main main = new Main();
        main.solution(input);
    }

}
