import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[] word = br.readLine().toCharArray();

            // 1. 뒤에서부터 오름차순으로 올라가다가 꺾이는 지점 탐색
            int firstIdx = word.length - 1;
            for (int i = word.length - 2; i >= 0; i--) {
                if (word[i] < word[i + 1]) {
                    firstIdx = i;
                    break;
                }
            }

            // 꺾이는 지점이 없다면 (완전히 내림차순) -> 다음 순열이 없으므로 그냥 단어 출력
            if (firstIdx == word.length - 1) {
                System.out.println(String.valueOf(word));
                continue;
            }

            // 2. 해당 지점 이후에서 가장 작은 값 탐색
            int secondIdx = firstIdx + 1;
            for (int i = firstIdx + 1; i < word.length; i++) {
                if (word[i] > word[firstIdx]) {
                    secondIdx = i;
                }
            }

            // 3. swap
            char tmp = word[firstIdx];
            word[firstIdx] = word[secondIdx];
            word[secondIdx] = tmp;

            // 4. 교체 이후 부분 오름차순 정렬
            Arrays.sort(word, firstIdx + 1, word.length);

            System.out.println(String.valueOf(word));
        }

    }

}
/*
HELLO = 7 4 11 11 14
DRINK = 3 17 8 13 10
SHUTTLE = 18 7 20 19 19 11 4
 */