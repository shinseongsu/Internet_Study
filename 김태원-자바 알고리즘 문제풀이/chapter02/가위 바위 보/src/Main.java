import java.util.Scanner;

/**
 * 가위 바보 보
 *
 * A, B 두 사람이 가위바위보 게임을 합니다.
 * 총 N반의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다.
 * 비길 경우에는 D를 출력합니다.
 *
 * 가위 바위 보의 정보는 1: 가위, 2: 바위, 3:보로 정하겠습니다.
 *
 * 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력예시1
 * 5
 * 2 3 3 1 3
 * 1 1 2 2 3
 *
 * 출력 예시1
 * A B A B D
 *
 *
 */
public class Main {

    public String[] solution(int N, int[] a, int[] b) {
        String[] answer = new String[N];

        for(int index = 0 ; index < N; index++) {
            if( a[index] == b[index] ) {
                answer[index] = "D";
            } else if ( a[index] == 3 && b[index] == 2 ) {
                answer[index] = "A";
            } else if ( a[index] == 2 && b[index] == 1 ) {
                answer[index] = "A";
            } else if ( a[index] == 1 && b[index] == 3 ) {
                answer[index] = "A";
            } else {
                answer[index] = "B";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] a = new int[N];
        int[] b = new int[N];

        for(int index = 0 ; index < N ; index++) {
            a[index] = scanner.nextInt();
        }

        for(int index = 0 ; index < N ; index++) {
            b[index] = scanner.nextInt();
        }

        Main main = new Main();
        String[] result = main.solution(N, a, b);

        for(String s : result) {
            System.out.println(s);
        }
    }

}
