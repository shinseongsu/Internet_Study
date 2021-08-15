import java.util.Scanner;

/**
 * 보이는 학생
 *
 * 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때,
 * 맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요.
 * (앞에 서 있는 사람들보다 크면 보이고, 작거나 같이면 보이지 않습니다.)
 *
 *
 * 입력 예시1
 * 8
 * 130 135 148 140 145 150 150 153
 *
 * 출력 예시1
 * 5
 *
 */
public class Main {

    public int solution(String[] arr) {
        int answer = 0;
        int max = 0;

        for(int index = 0 ; index < arr.length ; index++) {
            int temp = Integer.parseInt(arr[index]);
            if( max < temp ) {
                max = temp;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] arr = new String[N];
        for(int index = 0 ; index < N ; index++) {
            arr[index] = scanner.next();
        }
        scanner.close();

        Main main = new Main();
        System.out.println( main.solution(arr) );

    }

}
