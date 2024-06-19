import java.util.*;
import java.io.*;

class Main {
    
    private static final int[][] dp = new int[31][31];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int ans = combination(M, N);
            bw.write(String.valueOf(ans));
            bw.newLine();
        }
    
        bw.flush();
        bw.close();
    }
    
    // nCr = n-1Cr-1 + n-1Cr
    private static int combination(int n, int r) {
        // 이미 계산된 값일 경우
        if (dp[n][r] > 0) {
            return dp[n][r];
        }
        // nCn 인 경우 & nC0인 경우 -> 1
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }
        
        return dp[n][r] = combination(n-1, r-1) + combination(n-1, r);
    }
}