import java.util.Scanner;

/**
 * 특정 문자 뒤집기
 *
 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
 * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
 *
 * 입력에시
 * -----------
 * a#b!GE*T@S
 *
 * 출력예시
 * -----------
 * S#b!GE*T@a
 *
 */
public class Main {

    public String solution(String s) {
        char[] arr = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        if( !Character.isAlphabetic(arr[left]) ) {
            left++;
        } else if ( !Character.isAlphabetic(arr[right])) {
            right--;
        } else {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();

        Main main = new Main();
        System.out.println( main.solution(input) );
    }

}
