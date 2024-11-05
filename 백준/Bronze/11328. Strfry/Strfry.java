import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String before = st.nextToken();
            String after = st.nextToken();

            int[] alphabet = new int[26];
            for (int j = 0; j < before.length(); j++) {
                alphabet[before.charAt(j) - 'a']++;
            }

            for (int j = 0; j < after.length(); j++) {
                alphabet[after.charAt(j) - 'a']--;
            }

            boolean result = true;
            for (int j = 0; j < 26; j++) {
                if (alphabet[j] != 0) {
                    result = false;
                    break;
                }
            }

            if (result) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }

        }

    }
}
