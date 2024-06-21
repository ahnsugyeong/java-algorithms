import java.util.*;
import java.io.*;

class Main {
    
    public static int dp[] = new int[1000001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        
        for (int i = 4; i <= N; i++) {
            int a = 1000001, b = 1000001, c = 1000001;
            if (i % 3 == 0) {
                a = dp[i / 3] + 1;
            }
            if (i % 2 == 0) {
                b = dp[i / 2] + 1;
            }
            c = dp[i - 1] + 1;
            dp[i] = Math.min(Math.min(a, b), c);
        }
    
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(dp[N]));

        bw.flush();
        bw.close();
    }
    
}
