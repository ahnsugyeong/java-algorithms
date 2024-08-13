import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] map;
    static boolean[][] ans;
    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new boolean[R][C];    // .(바다): true, X(땅): false
        ans = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j) == '.';
            }
        }

        int minCol = 11;
        int maxCol = 0;
        int minRow = 11;
        int maxRow = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans[i][j] = check(i, j);
                if (!ans[i][j]) {
                    minCol = Math.min(minCol, i);
                    maxCol = Math.max(maxCol, i);
                    minRow = Math.min(minRow, j);
                    maxRow = Math.max(maxRow, j);
                }
            }
        }

        for (int i = minCol; i <= maxCol; i++) {
            for (int j = minRow; j <= maxRow; j++) {
                if (ans[i][j]) {
                    bw.write(".");
                } else {
                    bw.write("X");
                }
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static boolean check(int i, int j) {
        if (map[i][j]) {    // 이미 바다인 경우는 체크 X
            return true;
        }
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};

        int cnt = 0;
        for (int idx = 0; idx < 4; idx++) {
            int newCol = i + di[idx];
            int newRow = j + dj[idx];
            if (newCol < 0 || newCol > R - 1 || newRow < 0 || newRow > C - 1) {
                cnt++;
                continue;
            }
            if (!map[newCol][newRow]) {
                continue;
            }
            cnt++;
        }
        
        if (cnt >= 3) {
            return true;
        }
        return false;
    }
}