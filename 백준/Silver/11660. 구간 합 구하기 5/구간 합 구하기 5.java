import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][N];

        dp[0][0] = board[0][0];
        for (int i = 1; i < N; i++) {
            dp[0][i] = dp[0][i - 1] + board[0][i];
        }

        for (int i = 1; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                dp[i][j] = dp[i - 1][j] + sum + board[i][j];
                sum += board[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            int area = dp[x2][y2];
            if (y1 - 1 >= 0) {
                area -= dp[x2][y1 - 1];
            }
            if (x1 - 1 >= 0) {
                area -= dp[x1 - 1][y2];
            }
            if (x1 - 1 >= 0 && y1 - 1 >= 0) {
                area += dp[x1 - 1][y1 - 1];
            }

            System.out.println(area);
        }

    }
}
