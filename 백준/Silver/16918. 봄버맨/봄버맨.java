import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] board = new int[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                if (input.charAt(j) == '.') {
                    board[i][j] = -1;
                } else {
                    // 1초 동안 봄버맨은 아무것도 하지 않는다.
                    board[i][j] = 3;
                }
            }
        }

        int time = 0;
        while (time++ < N) {

            // 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다.
            if (time % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (board[i][j] == -1) {
                            board[i][j] = time + 3;
                        }
                    }
                }
            } else {
                // 3초 전에 설치된 폭탄이 모두 폭발한다.
                List<Dot> bombs = new ArrayList<>();
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (board[i][j] == time) {
                            bombs.add(new Dot(i, j));
                        }
                    }
                }

                for (Dot bomb : bombs) {
                    int row = bomb.row;
                    int col = bomb.col;

                    board[row][col] = -1;
                    if (row > 0) board[row - 1][col] = -1;
                    if (col > 0) board[row][col - 1] = -1;
                    if (row < R - 1) board[row + 1][col] = -1;
                    if (col < C - 1) board[row][col + 1] = -1;
                }
            }
        }

        printBoard(board, R, C);

    }

    static void printBoard(int[][] board, int R, int C) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == -1) {
                    System.out.print(".");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }
    }

    static class Dot {
        int row;
        int col;

        public Dot(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}