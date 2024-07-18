import java.util.*;
import java.io.*;

public class Main {

    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        if (R * C < K) {
            bw.write("0");
        } else {
            visited = new boolean[R][C];
            int curRow = R - 1;
            int curCol = 0;
            visited[curRow][curCol] = true;
            int dir = 0;
            for (int i = 0; i < K - 1; i++) {
                int newRow = curRow + dRow[dir];
                int newCol = curCol + dCol[dir];
                if (newRow < 0 || newRow > R - 1 || newCol < 0 || newCol > C - 1 || visited[newRow][newCol]) {
                    dir = (dir + 1) % 4;
                    i--;
                    continue;
                }

                visited[newRow][newCol] = true;
                curRow = newRow;
                curCol = newCol;
            }

            int x = curCol + 1;
            int y = R - curRow;
            bw.write(x + " " + y);
        }

        bw.flush();
        bw.close();
    }

}