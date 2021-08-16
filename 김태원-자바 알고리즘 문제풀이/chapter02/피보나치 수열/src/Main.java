import java.util.ArrayList;
import java.util.Scanner;

/**
 * 피보나치 수열
 *
 * 1) 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 * 2) 입력은 피보나치 수열의 총 합의 수 이다. 만약 7이 입력되면 1 1 2 3  5 8 13을 출력하면 된다.
 *
 * 입력1
 * 10
 *
 * 출력1
 * 1 1 2 3 5 8 13 21 34 55
 *
 *
 */
public class Main {

    public String solution(int N) {
        String answer = "";

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);

        for(int index = 2 ; index < N ; index++) {
            int a = list.get(index-2);
            int b = list.get(index-1);
            list.add(a + b);
        }

        for(Integer temp : list) {
            answer += temp + " ";
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
