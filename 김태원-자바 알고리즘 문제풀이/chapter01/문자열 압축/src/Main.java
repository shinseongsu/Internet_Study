import java.util.Scanner;

/**
 * 문자열 압축
 *
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 * 단 반복횟수가 1인 경우 생략합니다.
 *
 *
 * 입력 예시
 * KKHSSSSSSE
 *
 * 출력 예시
 * K2HS6E
 *
 */
public class Main {

    public String solution(String s) {
        String answer = "";
        s = s + " ";
        int count = 1;

        for(int index = 0 ; index < s.length() - 1 ; index++) {
            if( s.charAt(index) == s.charAt(index + 1)) {
                count++;
            } else {
                answer += s.charAt(index);
                if(count> 1) {
                    answer += String.valueOf(count);
                }

                count = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();

        Main main = new Main();
        System.out.println( main.solution(s) );
    }

}
