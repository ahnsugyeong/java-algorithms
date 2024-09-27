import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] prices = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                prices[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][3];
        dp[0][0] = prices[0][0];
        dp[0][1] = prices[0][1];
        dp[0][2] = prices[0][2];

        for (int i = 1; i < N; i++) {
            // R
            dp[i][0] = prices[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);

            // G
            dp[i][1] = prices[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);

            // B
            dp[i][2] = prices[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, dp[N - 1][0]);
        ans = Math.min(ans, dp[N - 1][1]);
        ans = Math.min(ans, dp[N - 1][2]);

        System.out.println(ans);
    }
}