import java.util.*;
import java.io.*;

public class Main {

    static int[][] board = new int[50][50];
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        int maxSize = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int size = calculateSize(i, j);
                maxSize = Math.max(maxSize, size);
            }
        }

        bw.write(String.valueOf(maxSize));
        bw.flush();
        bw.close();
    }

    private static int calculateSize(int col, int row) {
        int number = board[col][row];
        int len = 0;
        for (int i = col + 1; i < N; i++) {
            if (number != board[i][row]) {
                continue;
            }
            int gap = i - col;
            if (col + gap > N - 1 || row + gap > M - 1) {
                continue;
            }
            if (board[col][row + gap] == number && board[col + gap][row + gap] == number) {
                len = Math.max(len, gap + 1);
            }
        }

        return len * len;
    }

}