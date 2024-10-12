import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n];
        dp[0] = arr[0];

        if (n >= 2) {
            dp[1] = arr[0] + arr[1];
        }
        if (n >= 3) {
            dp[2] = arr[2] + Math.max(arr[0], arr[1]);
        }

        for (int i = 3; i < n; i++) {
            int prevMax = 0;
            for (int j = i - 3; j >= 0; j--) {
                prevMax = Math.max(prevMax, dp[j]);
            }

            dp[i] = arr[i] + Math.max(dp[i - 2], arr[i - 1] + prevMax);
        }

        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            maxVal = Math.max(maxVal, dp[i]);
        }
        
        System.out.println(maxVal);
    }
}