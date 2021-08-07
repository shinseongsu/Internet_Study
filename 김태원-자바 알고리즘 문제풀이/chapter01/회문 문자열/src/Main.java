import java.util.Scanner;

public class Main {

    public String solution(String s) {
        String answer = "YES";

        // 1번 풀이
        /*int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            char a = Character.toUpperCase( s.charAt(left) );
            char b = Character.toUpperCase( s.charAt(right) );

            if( a != b) {
                answer = "NO";
                break;
            }
            left++;
            right--;
        }*/

        // 2번 풀이
        /*s = s.toUpperCase();
        for(int index = 0 ; index < s.length() / 2 ; index++) {
            if( s.charAt(index) != s.charAt(s.length() - index - 1)) {
                answer = "NO";
                break;
            }
        }*/

        // 3번 풀이
        String temp = new StringBuilder(s).reverse().toString();
        if( !s.equalsIgnoreCase(temp) ) {
            answer = "NO";
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
