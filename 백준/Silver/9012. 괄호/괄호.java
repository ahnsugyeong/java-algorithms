import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            boolean result = isVPS(str);
            
            if (result) {
                bw.write("YES");
            } else {
                bw.write("NO");
            }
            
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
    }
    
    private static boolean isVPS(String str) {
        Stack<Character> s = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                s.push(str.charAt(i));    
            }
            if (str.charAt(i) == ')') {
                if (s.isEmpty()) {
                    return false;
                }
                s.pop();
            }
        }
        
        if (!s.isEmpty()) {
            return false;
        }
        return true;
    }
    
}
