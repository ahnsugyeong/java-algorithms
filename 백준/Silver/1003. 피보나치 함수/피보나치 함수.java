import java.util.*;
import java.io.*;

class Main {
    
    private static int dp[] = new int[41];
    private static int[] zeroCount = new int[41];
    private static int[] oneCount = new int[41];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        dp[0] = 0;
        dp[1] = 1;
        zeroCount[0] = 1;
        zeroCount[1] = 0;
        oneCount[0] = 0;
        oneCount[1] = 1;

        for (int i = 2; i <= 40; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            zeroCount[i] = zeroCount[i - 1] + zeroCount[i - 2];
            oneCount[i] = oneCount[i - 1] + oneCount[i - 2];
        }
        
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(zeroCount[N] + " " + oneCount[N]);
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
    }
}
