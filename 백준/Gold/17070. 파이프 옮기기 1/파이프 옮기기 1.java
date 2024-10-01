import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int cnt;
    static int[][] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = 0;

        house = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        DFS(1, 2, 0);
        
        System.out.println(cnt);
    }

    // dir -> 0: 가로, 1: 세로, 2: 대각선
    public static void DFS(int i, int j, int dir) {
        if (i == N && j == N) {
            cnt++;
            return;
        }
        if (dir == 0) {
            // 가로
            if (i >= 1 && i <= N && j + 1 >= 1 && j + 1 <= N && house[i][j + 1] == 0) {
                DFS(i, j + 1, 0);
            }
            // 대각선
            if (i + 1 >= 1 && i + 1 <= N && j + 1 >= 1 && j + 1 <= N && house[i + 1][j] == 0 && house[i][j + 1] == 0 && house[i + 1][j + 1] == 0) {
                DFS(i + 1, j + 1, 2);
            }
        } else if (dir == 1) {
            // 세로
            if (i + 1 >= 1 && i + 1 <= N && j >= 1 && j <= N && house[i + 1][j] == 0) {
                DFS(i + 1, j, 1);
            }
            // 대각선
            if (i + 1 >= 1 && i + 1 <= N && j + 1 >= 1 && j + 1 <= N && house[i + 1][j] == 0 && house[i][j + 1] == 0 && house[i + 1][j + 1] == 0) {
                DFS(i + 1, j + 1, 2);
            }
        } else if (dir == 2) {
            // 가로
            if (i >= 1 && i <= N && j + 1 >= 1 && j + 1 <= N && house[i][j + 1] == 0) {
                DFS(i, j + 1, 0);
            }
            // 세로
            if (i + 1 >= 1 && i + 1 <= N && j >= 1 && j <= N && house[i + 1][j] == 0) {
                DFS(i + 1, j, 1);
            }
            // 대각선
            if (i + 1 >= 1 && i + 1 <= N && j + 1 >= 1 && j + 1 <= N && house[i + 1][j] == 0 && house[i][j + 1] == 0 && house[i + 1][j + 1] == 0) {
                DFS(i + 1, j + 1, 2);
            }
        }
    }
}
