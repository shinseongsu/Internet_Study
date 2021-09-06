import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 공통원소 구하기
 *
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 번째 줄에 집합 A 의 크기 N이 주어집니다.
 * 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * 세 번째 줄에 집합 B의 크기 M이 주어집니다.
 * 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * 각 집합의 원소는 1,000,000,000 이하의 자연수입니다.
 *
 * 출력
 * 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
 *
 * 예시 입력1
 * 5 1 3 9 5 2 5 3 2 5 7 8
 *
 * 출력
 * 2 3 5
 *
 *
 */
public class Main {

    public int[] solution(int N, int M, int[] a, int[] b) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(a);
        Arrays.sort(b);

        int p1 = 0;
        int p2 = 0;
        while( p1 < N && p2 < M ) {
            if( a[p1] == b[p2] ) {
                list.add(a[p1]);
                p1++;
                p2++;
            } else if ( a[p1] < b[p2] ) {
                p1++;
            } else {
                p2++;
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0 ; i < answer.length ; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] a = new int[N];

        for(int i = 0; i < N ; i++) {
            a[i] = scanner.nextInt();
        }

        int M = scanner.nextInt();
        int[] b = new int[M];
        for(int i = 0 ; i < M ; i++) {
            b[i] = scanner.nextInt();
        }
        scanner.close();

        Main main = new Main();
        int[] result = main.solution(N, M, a, b);

        for(int i = 0 ; i < result.length ; i++) {
            System.out.println(result[i] + " ");
        }
    }

}
