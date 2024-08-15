import java.util.*;
import java.io.*;

public class Main {

    static int dir = 0;    // 0: 남, 1: 서, 2: 북, 3: 동
    static int[] dCol = {1, 0, -1, 0};
    static int[] dRow = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        boolean[][] visited = new boolean[N * 2 + 1][N * 2 + 1];
        int col = N, row = N;
        visited[col][row] = true;
        int minCol = N;
        int maxCol = N;
        int minRow = N;
        int maxRow = N;

        for (int i = 0; i < input.length(); i++) {
            char order = input.charAt(i);
            if (order == 'F') {
                col += dCol[dir];
                row += dRow[dir];
                visited[col][row] = true;
                minCol = Math.min(minCol, col);
                maxCol = Math.max(maxCol, col);
                minRow = Math.min(minRow, row);
                maxRow = Math.max(maxRow, row);
            } else {
                changeDir(order);
            }
        }

        for (int i = minCol; i <= maxCol; i++) {
            for (int j = minRow; j <= maxRow; j++) {
                if (visited[i][j]) {
                    bw.write(".");
                } else {
                    bw.write("#");
                }
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static void changeDir(char order) {
        if (order == 'R') {
            dir = (dir + 1) % 4;
        } else if (order == 'L') {
            dir = (dir + 3) % 4;
        }
    }

}