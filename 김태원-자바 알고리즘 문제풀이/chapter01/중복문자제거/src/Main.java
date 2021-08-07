import java.util.Scanner;

/**
 * 중복문자제거
 *
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
 * 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 *
 * 입력1
 * ksekkset
 *
 * 출력
 * kset
 *
 */
public class Main {

    public String solution(String s) {
        String answer = "";

        for(int index = 0 ; index < s.length() ; index++) {
            if(s.indexOf(s.charAt(index)) == index)
                answer += s.charAt(index);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();

        Main main = new Main();
        System.out.println( main.solution(input) );
    }

}
