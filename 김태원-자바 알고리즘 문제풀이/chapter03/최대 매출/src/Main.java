import java.util.Scanner;

/**
 * 최대 매출
 *
 * 현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고
 * 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
 *
 * 만약 N = 10 이고 10일간의 매출기록이 아래와 같습니다.
 * 이때 K = 3 이면
 * 12 1511 20 2510 20 19 13 15
 * 연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
 *
 * 여러분이 현수를 도와주세요.
 *
 * 입력
 * 첫 줄에 N과 K가 주어집니다.
 * 두 번째 줄에 N개의 숫자열이 주어집니다.
 * 각 숫자는 500이하의 음이 아닌 정수입니다.
 *
 * 출력
 * 첫 줄에 최대 매출액을 출력합니다.
 *
 * 예시 입력1
 * 10 3 12 15 11 20 25 10 20 19 13 15
 *
 * 예시 출력1
 * 56
 *
 *
 */
public class Main {

    public int solution(int N, int K, int[] arr) {
        int answer = 0;

        int total = 0;
        for(int i = 0 ; i < K ; i++) {
            total += arr[i];
        }
        answer = total;
        for(int i = K ; i < N ; i++) {
            total = total - arr[i - K] + arr[i];
            answer = Math.max(answer, total);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] arr = new int[N];

        for(int i = 0 ; i < N ; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        Main main = new Main();
        System.out.println( main.solution( N, K, arr ) );
    }

}
