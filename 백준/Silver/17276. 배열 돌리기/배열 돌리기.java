import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int[][] board = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (d < 0) {
                d += 360;
            }

            for (int i = 0; i < d / 45; i++) {
                board = rotate(board, n);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

        }
    }

    static int[][] rotate(int[][] board, int n) {
        int[][] result = new int[n][n];

        // X의 주 대각선을 ((1,1), (2,2), …, (n, n)) 가운데 열 ((n+1)/2 번째 열)로 옮긴다.
        for (int i = 0; i < n; i++) {
            result[i][(n - 1) / 2] = board[i][i];
        }

        // X의 가운데 열을 X의 부 대각선으로 ((n, 1), (n-1, 2), …, (1, n)) 옮긴다.
        for (int i = 0; i < n; i++) {
            result[i][n - i - 1] = board[i][(n - 1) / 2];
        }

        // X의 부 대각선을 X의 가운데 행 ((n+1)/2번째 행)으로 옮긴다.
        for (int i = 0; i < n; i++) {
            result[(n - 1) / 2][i] = board[n - i - 1][i];
        }

        // X의 가운데 행을 X의 주 대각선으로 옮긴다.
        for (int i = 0; i < n; i++) {
            result[i][i] = board[(n - 1) / 2][i];
        }

        // X의 다른 원소의 위치는 변하지 않는다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] == 0) {
                    result[i][j] = board[i][j];
                }
            }
        }

        return result;
    }

}