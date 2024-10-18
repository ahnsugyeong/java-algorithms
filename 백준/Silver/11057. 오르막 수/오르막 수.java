import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 10007;
            }
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[N][i];
            answer %= 10007;
        }

        System.out.println(answer);
    }
}