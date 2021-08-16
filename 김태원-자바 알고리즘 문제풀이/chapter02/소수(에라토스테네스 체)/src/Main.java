import java.util.Scanner;

/**
 * 소수(에라토스테네스 체)
 *
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 4, 7, 11, 13, 17, 19로 총 8개입니다.
 *
 * 입력예시1
 * 20
 *
 * 출력예시1
 * 8
 *
 *
 */
public class Main {

    public int solution(int N) {
        int answer = 0;

        int[] arr = new int[N+1];

        for(int i = 2 ; i <= N ; i++) {
            if( arr[i] == 0 ) {
                answer++;
                for(int j = i ; j <= N ; j = j + i) {
                    arr[j] = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        Main main = new Main();
        System.out.println( main.solution(N) );

    }

}
