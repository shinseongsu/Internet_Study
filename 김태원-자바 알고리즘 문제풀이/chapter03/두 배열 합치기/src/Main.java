import java.util.ArrayList;
import java.util.Scanner;

/**
 * 두 배열 합치기
 *
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 번째 줄에 첫 번째 배열의 크기 N이 주어집니다.
 * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 * 세 번째 두 번째 배열의 크기 M이 주어집니다.
 * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 *
 * 출력
 * 오름차순으로 정렬된 배열을 출력합니다.
 *
 * 예시 입력
 * 1 3 1 3 5 5 2 3 6 7 9
 *
 * 예시 출력
 * 1 1 2 3 3 5 6 7 9
 *
 *
 */
public class Main {

    public int[] solution(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[] answer = new int[a.length + b.length];
        ArrayList<Integer> temp = new ArrayList<Integer>();

        int p1 = 0;
        int p2 = 0;
        while( p1 < n && p2 < m ) {
            if( a[p1] < b[p2] ) {
                temp.add(a[p1++]);
            } else {
                temp.add(b[p2++]);
            }
        }

        while(p1 < n)
            temp.add(a[p1++]);

        while(p2 < m)
            temp.add(b[p2++]);

        for(int i = 0; i < temp.size(); i++){
            answer[i] = temp.get(i);
        }
        return answer;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] a = new int[N];

        for(int i = 0 ; i < N ; i++) {
            a[i] = scanner.nextInt();
        }

        N = scanner.nextInt();
        int[] b = new int[N];
        for(int i = 0 ; i < N ; i++) {
            b[i] = scanner.nextInt();
        }
        scanner.close();

        Main main = new Main();
        int[] result = main.solution(a, b);

    }

}
