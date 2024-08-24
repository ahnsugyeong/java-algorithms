import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[n][m];
        int[] dCol = {0, 0, 1, -1};
        int[] dRow = {1, -1, 0, 0};
        int cnt = 0;
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 0 || visited[i][j]) {
                    continue;
                }

                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                visited[i][j] = true;
                cnt++;

                int size = 0;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    size++;
                    for (int idx = 0; idx < 4; idx++) {
                        int newCol = cur[0] + dCol[idx];
                        int newRow = cur[1] + dRow[idx];
                        if (newCol < 0 || newCol > n - 1 || newRow < 0 || newRow > m - 1 || paper[newCol][newRow] == 0 || visited[newCol][newRow]) {
                            continue;
                        }
                        visited[newCol][newRow] = true;
                        q.add(new int[]{newCol, newRow});
                    }
                }

                maxSize = Math.max(maxSize, size);
            }
        }

        bw.write(String.valueOf(cnt));
        bw.newLine();
        bw.write(String.valueOf(maxSize));
        br.close();
        bw.flush();
        bw.close();
    }

}