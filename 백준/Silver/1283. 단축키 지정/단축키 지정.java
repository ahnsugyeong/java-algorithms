import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String option = br.readLine();
            int index = findKeyIndex(option);
            String key = printKey(option, index);
            System.out.println(key);
        }

    }

    static String printKey(String option, int index) {
        if (index == -1) {
            return option;
        }

        String ans = "";
        for (int i = 0; i < option.length(); i++) {
            if (i == index) {
                ans += "[";
                ans += option.charAt(i);
                ans += "]";
            } else {
                ans += option.charAt(i);
            }
        }
        return ans;
    }

    static int findKeyIndex(String option) {
        // 1. 먼저 하나의 옵션에 대해 왼쪽에서부터 오른쪽 순서로 단어의 첫 글자가 이미 단축키로 지정되었는지 살펴본다. 만약 단축키로 아직 지정이 안 되어있다면 그 알파벳을 단축키로 지정한다.
        for (int i = 0; i < option.length() - 1; i++) {
            // 단어의 첫 글자인 경우
            if (i == 0 || option.charAt(i - 1) == ' ') {
                int alphabetIdx = getAlphabetIndex(option.charAt(i));
                if (!visited[alphabetIdx]) {
                    visited[alphabetIdx] = true;
                    return i;
                }
            }
        }

        // 2. 만약 모든 단어의 첫 글자가 이미 지정이 되어있다면 왼쪽에서부터 차례대로 알파벳을 보면서 단축키로 지정 안 된 것이 있다면 단축키로 지정한다.
        for (int i = 0; i < option.length(); i++) {
            if (option.charAt(i) == ' ') {
                continue;
            }
            int alphabetIdx = getAlphabetIndex(option.charAt(i));
            if (!visited[alphabetIdx]) {
                visited[alphabetIdx] = true;
                return i;
            }
        }
        return -1;
    }

    static int getAlphabetIndex(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        } else if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        }
        return -1;
    }

}
