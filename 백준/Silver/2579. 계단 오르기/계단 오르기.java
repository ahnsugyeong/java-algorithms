import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N + 1];
        dp[1] = scores[1];
        if (N >= 2) {
            dp[2] = scores[1] + scores[2];
        }
        for (int i = 3; i <= N; i++) {
            dp[i] = scores[i] + Math.max(dp[i - 2], dp[i - 3] + scores[i - 1]);
        }

        System.out.println(dp[N]);
    }
}