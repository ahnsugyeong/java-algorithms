import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String before = br.readLine();
        String after = br.readLine();

        int[] alphabet = new int[26];
        for (int j = 0; j < before.length(); j++) {
            alphabet[before.charAt(j) - 'a']++;
        }

        for (int j = 0; j < after.length(); j++) {
            alphabet[after.charAt(j) - 'a']--;
        }

        int result = 0;
        for (int j = 0; j < 26; j++) {
            if (alphabet[j] != 0) {
                result += Math.abs(alphabet[j]);
            }
        }
        System.out.println(result);
    }
}
