import java.io.*;
import java.util.*;

public class Main {

    static int[] queenRow = {0, 0, 1, -1, -1, 1, 1, -1};
    static int[] queenCol = {1, -1, 0, 0, 1, 1, -1, -1};

    static int[] knightRow = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] knightCol = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] board = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        int queenCnt = Integer.parseInt(st.nextToken());
        List<Pos> queens = new ArrayList<>();
        for (int i = 0; i < queenCnt; i++) {
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            board[row][col] = true;
            queens.add(new Pos(row, col));
        }

        st = new StringTokenizer(br.readLine());
        int knightCnt = Integer.parseInt(st.nextToken());
        List<Pos> knights = new ArrayList<>();
        for (int i = 0; i < knightCnt; i++) {
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            board[row][col] = true;
            knights.add(new Pos(row, col));
        }

        st = new StringTokenizer(br.readLine());
        int pawnCnt = Integer.parseInt(st.nextToken());
        List<Pos> pawns = new ArrayList<>();
        for (int i = 0; i < pawnCnt; i++) {
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            board[row][col] = true;
            pawns.add(new Pos(row, col));
        }

        // Queen: 가로, 세로, 대각선으로 갈 수 있는 만큼 최대한 많이 이동을 할 수 있는데 만약 그 중간에 장애물이 있다면 이동을 할 수 없다.
        boolean[][] check = new boolean[n][m];
        for (int i = 0; i < queenCnt; i++) {
            Pos queen = queens.get(i);
            check[queen.row][queen.col] = true;

            for (int idx = 0; idx < 8; idx++) {
                int newRow = queen.row + queenRow[idx];
                int newCol = queen.col + queenCol[idx];

                while (newRow >= 0 && newRow <= n - 1 && newCol >= 0 && newCol <= m - 1 && !board[newRow][newCol]) {
                    check[newRow][newCol] = true;
                    newRow += queenRow[idx];
                    newCol += queenCol[idx];
                }
            }
        }

        // Knight: 2×3 직사각형을 그렸을 때, 반대쪽 꼭짓점으로 이동을 할 수 있다.
        for (int i = 0; i < knightCnt; i++) {
            Pos knight = knights.get(i);
            check[knight.row][knight.col] = true;

            for (int idx = 0; idx < 8; idx++) {
                int newRow = knight.row + knightRow[idx];
                int newCol = knight.col + knightCol[idx];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    check[newRow][newCol] = true;
                }
            }
        }

        // Pawn: 상대팀의 말은 잡을 수 없다고 하자(즉, 장애물의 역할만 한다는 것이다).
        for (int i = 0; i < pawnCnt; i++) {
            Pos pawn = pawns.get(i);
            check[pawn.row][pawn.col] = true;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    static class Pos {
        int row;
        int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}