import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static int ansCol = 0, ansRow = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[19][19];
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] == 0) {
                    continue;
                }

                if (checkWidth(i, j) || checkHeight(i, j) || checkFirstDiagonal(i, j) || checkSecondDiagonal(i, j)) {
                    System.out.println(board[i][j]);
                    System.out.println((ansCol + 1) + " " + (ansRow + 1));
                    return;
                }
            }
        }

        System.out.println(0);
    }

    static boolean checkWidth(int col, int row) {
        int cnt = 1;
        int tmpCol = col, tmpRow = row;

        // 왼쪽
        for (int i = row - 1; i >= 0; i--) {
            if (board[col][row] == board[col][i]) {
                cnt++;
                tmpCol = col;
                tmpRow = i;
            } else {
                break;
            }
        }

        // 오른쪽
        for (int i = row + 1; i < 19; i++) {
            if (board[col][row] == board[col][i]) {
                cnt++;
            } else {
                break;
            }
        }

        if (cnt == 5) {
            ansCol = tmpCol;
            ansRow = tmpRow;
        }

        return cnt == 5;
    }

    static boolean checkHeight(int col, int row) {
        int cnt = 1;
        int tmpCol = col, tmpRow = row;

        // 위쪽
        for (int i = col - 1; i >= 0; i--) {
            if (board[col][row] == board[i][row]) {
                cnt++;
                tmpCol = i;
                tmpRow = row;
            } else {
                break;
            }
        }

        // 아래쪽
        for (int i = col + 1; i < 19; i++) {
            if (board[col][row] == board[i][row]) {
                cnt++;
            } else {
                break;
            }
        }

        if (cnt == 5) {
            ansCol = tmpCol;
            ansRow = tmpRow;
        }

        return cnt == 5;
    }

    // / 모양
    static boolean checkFirstDiagonal(int col, int row) {
        int cnt = 1;
        int tmpCol = col, tmpRow = row;

        // 왼쪽 아래
        for (int i = col + 1, j = row - 1; i < 19 && j >= 0; i++, j--) {
            if (board[col][row] == board[i][j]) {
                cnt++;
                tmpCol = i;
                tmpRow = j;
            } else {
                break;
            }
        }

        // 오른쪽 위
        for (int i = col - 1, j = row + 1; i >= 0 && j < 19; i--, j++) {
            if (board[col][row] == board[i][j]) {
                cnt++;
            } else {
                break;
            }
        }

        if (cnt == 5) {
            ansCol = tmpCol;
            ansRow = tmpRow;
        }

        return cnt == 5;
    }

    // \ 모양
    static boolean checkSecondDiagonal(int col, int row) {
        int cnt = 1;
        int tmpCol = col, tmpRow = row;

        // 왼쪽 위
        for (int i = col - 1, j = row - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[col][row] == board[i][j]) {
                cnt++;
                tmpCol = i;
                tmpRow = j;
            } else {
                break;
            }
        }

        // 오른쪽 아래
        for (int i = col + 1, j = row + 1; i < 19 && j < 19; i++, j++) {
            if (board[col][row] == board[i][j]) {
                cnt++;
            } else {
                break;
            }
        }

        if (cnt == 5) {
            ansCol = tmpCol;
            ansRow = tmpRow;
        }

        return cnt == 5;
    }


}