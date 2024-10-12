import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        B = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                B[i][j] = input.charAt(j) - '0';
            }
        }

        // 모든 부분행렬 탐색
        int cnt = 0;
        for (int i = 0; i + 2 < N; i++) {
            for (int j = 0; j + 2 < M; j++) {
                if (A[i][j] == B[i][j]) {
                    continue;
                }

                // 뒤집기
                reverse(i, j);
                cnt++;
            }
        }

        if (!checkIfSame()) {
            cnt = -1;
        }

        System.out.println(cnt);

    }

    static void reverse(int row, int col) {
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                A[i][j] = A[i][j] == 1 ? 0 : 1;
            }
        }
    }

    static boolean checkIfSame() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}