import java.util.Scanner;

/**
 * 대소문자 변환
 *
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로
 * 변환하여 출력하는 프로그램을 작성하라.
 *
 * 예시 입력1
 * StuDY
 *
 * 예시 출력1
 * sTUdy
 *
 */
class Main {

    public String solution(String source) {
        String answer = "";

        // 1. Character 이용
        for(char c : source.toCharArray()) {
            if(Character.isLowerCase(c)) {
                answer += Character.toUpperCase(c);
            } else {
                answer += Character.toLowerCase(c);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String source = sc.next();
        sc.close();

        Main main = new Main();
        System.out.println( main.solution(source) );
    }

}
