import java.util.Scanner;

/**
 * 숫자만 추출
 *
 * 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 맍듭니다.
 * 만약 "g0en2T0s8eSoft"에서 숫자만 추출하면 2, 0, 8 이고 이것을 자연수를 만들면 208 이다.
 * 추출하면 만들어지는 자연수는 100,000,000을 넘지 않습니다.
 *
 * 입력1
 * g0en2T0s8eSoft
 *
 * 출력1
 * 208
 *
 */
public class Main {

    public int solution(String s) {
        int answer = 0;

        // 방법1
        /*s = s.replaceAll("[^0-9]", "");
        answer = Integer.parseInt(s);*/

        // 방법2
        /*String temp = "";
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                temp += c;
            }
        }
        answer = Integer.parseInt(temp);*/

        // 방법3
        for(char c : s.toCharArray()) {
            // 문자 '0' 의 ASCII 코드 : 48
            // 문자 '9' 의 ASCII 코드 : 57
            if( 48 <= c && c <= 57 ) {
                answer = answer * 10 + (c - 48);
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
