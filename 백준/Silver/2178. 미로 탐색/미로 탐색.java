import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] maze = new char[N][M];
        for (int i = 0; i < N; i++) {
            maze[i] = br.readLine().toCharArray();
        }

        int[] dRow = {0, 0, 1, -1};
        int[] dCol = {1, -1, 0, 0};
        boolean[][] visited = new boolean[N][M];

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0, 0, 1));
        visited[0][0] = true;

        int ans = -1;
        while (!q.isEmpty()) {
            Info cur = q.poll();
            if (cur.row == N - 1 && cur.col == M - 1) {
                ans = cur.cnt;
                break;
            }

            for (int idx = 0; idx < 4; idx++) {
                int newRow = cur.row + dRow[idx];
                int newCol = cur.col + dCol[idx];

                // 칸을 벗어나는 경우
                if (newRow < 0 || newRow > N - 1 || newCol < 0 || newCol > M - 1) {
                    continue;
                }
                // 이미 방문했거나, 이동할 수 없는 칸인 경우
                if (visited[newRow][newCol] || maze[newRow][newCol] == '0') {
                    continue;
                }

                visited[newRow][newCol] = true;
                q.add(new Info(newRow, newCol, cur.cnt + 1));
            }

        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    private static class Info {
        int row;
        int col;
        int cnt;

        private Info(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }

}