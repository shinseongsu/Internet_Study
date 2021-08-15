import java.util.Scanner;


/**
 * 큰 수 출력하기
 *
 * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
 * (첫 번째는 수는 무조건 출력한다.)
 *
 *
 * 입력 예시 1
 * 6
 * 7 3 9 5 6 12
 *
 * 출력 예시 2
 * 7 9 6 12
 *
 *
 */
public class Main {

    public String solution(int N, int[] arr) {
        String answer = arr[0] + "";

        for(int index = 1 ; index < N ; index++) {
            if( arr[index-1] < arr[index]) {
                answer += (!answer.equals("") ? " " : "") + arr[index];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] arr = new int[N];

        for(int i = 0 ; i < N ; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        Main main = new Main();
        System.out.println( main.solution(N, arr) );
    }

}
