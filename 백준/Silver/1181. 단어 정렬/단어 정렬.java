import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       
       // 중복 단어 제거
       Set<String> wordSet = new HashSet<>();
       for(int i = 0; i < N; i++) {
           wordSet.add(br.readLine());
       }
       
       List<String> words = new ArrayList<>(wordSet);
       words.sort(new WordComparator());
       
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       for(String word: words) {
           bw.write(word);
           bw.newLine();
       }
       
       bw.flush();
       bw.close();
    }
    
    static class WordComparator implements Comparator<String> {
        
        @Override
        public int compare(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return 1;
            } else if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            return -1;
        }
        
    }
}