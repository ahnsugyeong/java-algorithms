import java.util.*;
import java.io.*;

public class Main {

    static int[][] board;
    static int[] dRow = {0, 1, 0, -1};
    static int[] dCol = {1, 0, -1, 0};
    static int dir = 3; // 동 남 서 북

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        board = new int[N][N];

        int cur = 1;    // board에 들어갈 숫자
        int curRow = N / 2;
        int curCol = N / 2;
        int cnt = 0;    // 한 방향 당 채울 숫자의 개수
        board[curRow][curCol] = cur;
        cur++;

        int ansRow = curRow + 1;
        int ansCol = curCol + 1;
        while (cur <= N * N) {
            if (dir == 1 || dir == 3) {
                cnt++;
            }

            for (int j = 0; j < cnt; j++) {
                if (cur > N * N) {
                    break;
                }
                curRow += dRow[dir];
                curCol += dCol[dir];

                board[curRow][curCol] = cur;
                if (cur == M) {
                    ansRow = curRow + 1;
                    ansCol = curCol + 1;
                }
                cur++;
            }
            setNextDir();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(board[i][j] + " ");
            }
            bw.newLine();
        }

        bw.write(ansRow + " " + ansCol);

        bw.flush();
        bw.close();
    }

    private static void setNextDir() {
        dir = (dir + 1) % 4;
    }
}