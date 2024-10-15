import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(getMaxNumber(input));
        System.out.println(getMinNumber(input));
    }

    static String getMaxNumber(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'M') {
                // K가 나올 때까지 탐색
                int j = i;
                while (j < input.length() && input.charAt(j) == 'M') {
                    j++;
                }

                // K가 나오지 않고 M만 연속되는 경우
                if (j == input.length()) {
                    sb.append("1".repeat(j - i));
                } else {    // 마지막에 K가 나온 경우
                    sb.append("5" + "0".repeat(j - i));
                }

                i = j;  // 반복문 끝나고 i++ 됨
            } else {    // 앞에 M이 없고 K만 존재하는 경우
                sb.append("5");
            }
        }

        return sb.toString();
    }

    // 가장 작은 수의 조건
    static String getMinNumber(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'K') {
                sb.append("5");
            } else {
                int j = i;
                while (j < input.length() && input.charAt(j) == 'M') {
                    j++;
                }
                sb.append("1" + "0".repeat(j - i - 1));
                i = j - 1;
            }
        }

        return sb.toString();
    }

}