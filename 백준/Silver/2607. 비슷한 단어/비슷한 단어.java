import java.util.*;
import java.io.*;

public class Main {

    static int[] originCnt, otherCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String originWord = br.readLine();
        originCnt = new int[26];
        countChars(originWord, originCnt);

        int cnt = 0;
        for (int i = 0; i < N - 1; i++) {
            int diff = 0;
            String otherWord = br.readLine();
            otherCnt = new int[26];
            countChars(otherWord, otherCnt);

            for (int j = 0; j < 26; j++) {
                diff += Math.abs(otherCnt[j] - originCnt[j]);
            }

            if (diff == 0) {
                cnt++;
            } else if (originWord.length() - 1 == otherWord.length() && diff == 1) {
                cnt++;
            } else if (originWord.length() + 1 == otherWord.length() && diff == 1) {
                cnt++;
            } else if (originWord.length() == otherWord.length() && diff == 2) {
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    static void countChars(String word, int[] count) {
        for (char ch : word.toCharArray()) {
            count[ch - 'A']++;
        }
    }

}