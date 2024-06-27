import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String name = br.readLine();

        int[] alphabet = new int[26];
        for (int i = 0; i < name.length(); i++) {
            int idx = name.charAt(i) - 'A';
            alphabet[idx]++;
        }

        int oddCount = 0;
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] % 2 != 0) {
                oddCount++;
            }
        }

        String ans = "";
        StringBuilder sb = new StringBuilder();
        if (oddCount > 1) {
            ans += "I'm Sorry Hansoo";
        } else {
            // start
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < alphabet[i] / 2; j++) {
                    sb.append((char) ('A' + i));
                }
            }
            ans += sb.toString();

            // mid
            for (int i = 0; i < 26; i++) {
                if (alphabet[i] % 2 != 0) {
                    ans += ((char) ('A' + i));
                }
            }

            // end
            String end = sb.reverse().toString();
            ans += end;
        }

        bw.write(ans);
        bw.flush();
        bw.close();
    }
}