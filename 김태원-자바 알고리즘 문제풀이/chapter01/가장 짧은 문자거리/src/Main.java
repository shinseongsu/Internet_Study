import java.util.Scanner;

/**
 * 가장 짧은 문자거리
 *
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 *
 * 입력 예시
 * teachermode e
 *
 * 출력 예시
 * 1 0 1 2 1 0 1 2 2 1 0
 *
 */
public class Main {

    public String solution(String s, String t) {
        String answer = "";
        int[] arr = new int[s.length()];
        int length = 1000;

        for(int index = 0 ; index < s.length() ; index = index + 1) {
            char c = s.charAt(index);
            if( !Character.toString(c).equals(t) ) {
                length = length + 1;
            } else {
                length = 0;
            }
            arr[index] = length;
        }

        length = 1000;
        for(int index = s.length() - 1 ; index >= 0 ; index = index - 1) {
            char c = s.charAt(index);
            if( !Character.toString(c).equals(t) ) {
                length = length + 1;
            } else {
                length = 0;
            }

            arr[index] = Math.min(arr[index], length);
        }

        for(int temp : arr) {
            answer += (!answer.equals("")) ? " " + temp : temp;
         }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        scanner.close();

        Main main = new Main();
        System.out.println( main.solution(s, t) );
    }

}
