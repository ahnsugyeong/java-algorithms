import java.io.*;
import java.util.*;

public class Main {

    static int[][] mars;
    static int[][] dp;
    static boolean[][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mars = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                mars[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫 번째 행 초기화
        dp[0][0] = mars[0][0];
        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i - 1] + mars[0][i];
        }

        for (int i = 1; i < N; i++) {
            // 값이 덮어씌워지지 않게 tmp 배열 사용
            int[][] tmp = new int[2][M];

            // 왼쪽 + 위쪽 (탐색 순서가 일정하기 때문에 덮어쓰여도 올바른 값 유지)
            tmp[0][0] = dp[i - 1][0] + mars[i][0];
            for (int j = 1; j < M; j++) {
                tmp[0][j] = Math.max(tmp[0][j - 1], dp[i - 1][j]) + mars[i][j];
            }

            // 오른쪽
            tmp[1][M - 1] = dp[i - 1][M - 1] + mars[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                tmp[1][j] = Math.max(tmp[1][j + 1], dp[i - 1][j]) + mars[i][j];
            }

            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(tmp[0][j], tmp[1][j]);
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}