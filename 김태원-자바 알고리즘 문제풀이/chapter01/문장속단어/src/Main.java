import java.util.Scanner;

/**
 * 문장 속 단언
 *
 * 한 개의 문장이 주어지면 그 문장 속에 가장 긴 단어를 출력하는 프로그럄을 작성하세요.
 * 문자속의 각 단어는 공백으로 구분됩니다.
 *
 * 입력
 * -------
 * it is time to study
 *
 * 출력
 * -------
 * study
 *
 */
public class Main {

    public String solution(String input) {
        String answer = "";
        String[] arr = input.split(" ");
        int max = 0;

        // 방법1
        for(String s : arr) {
            if(s.length() > max) {
                max = s.length();
                answer = s;
            }
        }

        // 방법2
        /*int pos = 0;
        while( (pos = input.indexOf(' ')) != -1 ) {
            String s = input.substring(0, pos);
            if(s.length() > max) {
                max = s.length();
                answer = s;
            }
            input = input.substring(pos + 1);
        }
        if(answer.length() < input.length()) {
            answer = input;
        }*/

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        Main main = new Main();
        System.out.println(main.solution(input));
    }

}
