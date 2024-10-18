import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M + 1];
        boolean[][] visited = new boolean[N][M + 1];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        List<CrossInfo> crossInfos = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int k = 1, size = 0;
                while (true) {
                    if (i - k < 0 || i + k > N - 1 || j - k < 0 || j + k > M - 1) {
                        break;
                    }
                    if (board[i - k][j] == '.' || board[i + k][j] == '.' || board[i][j - k] == '.' || board[i][j + k] == '.') {
                        break;
                    }
                    size = k++;
                }

                if (size == 0) {
                    continue;
                }

                visited[i][j] = true;
                for (int l = 1; l <= size; l++) {
                    visited[i - l][j] = true;
                    visited[i + l][j] = true;
                    visited[i][j - l] = true;
                    visited[i][j + l] = true;
                }

                for (int l = size; l >= 1; l--) {
                    crossInfos.add(new CrossInfo(i, j, l));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == '*' && !visited[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(crossInfos.size());
        for (CrossInfo crossInfo : crossInfos) {
            crossInfo.print();
        }

    }

    static class CrossInfo {
        int row;
        int col;
        int size;

        public CrossInfo(int row, int col, int size) {
            this.row = row;
            this.col = col;
            this.size = size;
        }

        public void print() {
            System.out.println((row + 1) + " " + (col + 1) + " " + size);
        }
    }
}