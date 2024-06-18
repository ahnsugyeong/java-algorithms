import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            if (isGroupWord(word)) {
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }
    
    public static boolean isGroupWord(String word) {
        Set<Character> check = new HashSet<>();
        
        for(int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                continue;
            }
            if (check.contains(word.charAt(i))) {
                return false;
            }
            check.add(word.charAt(i));
        }
        if (check.contains(word.charAt(word.length() - 1))) {
            return false;
        }
        return true;
    }
    
}