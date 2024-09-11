import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alphabet = new int[26];
        String S = br.readLine();
        for (int i = 0; i < S.length(); i++) {
            alphabet[S.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(alphabet[i] + " ");
        }
    }

}
