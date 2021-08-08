import java.util.Scanner;

/**
 * 문자 찾기
 *
 * 한 개의 문자열을 입력 받고, 특정 문잘르 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그앰을 작성하세요.
 * 대소문자를 구분하지 않습니다. 문자열의 길이는 100을 넘지 않습니다.
 *
 * 입력
 * --------
 * Computercooler c
 *
 * 출력
 * --------
 * 2
 *
 */
class Main {

    public int solution(String source, char target) {
        int answer = 0;
        source = source.toUpperCase();
        target = Character.toUpperCase(target);

        for(char x : source.toCharArray()) {
            if( x == target )
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String source = sc.next();
        char target = sc.next().charAt(0);
        sc.close();

        Main main = new Main();
        System.out.println( main.solution(source, target) );

    }

}