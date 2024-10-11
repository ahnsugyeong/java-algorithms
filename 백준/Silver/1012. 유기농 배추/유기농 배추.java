import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int[] dRow = {0, 0, 1, -1};
    static int[] dCol = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            boolean[][] graph = new boolean[N][M];
            boolean[][] visited = new boolean[N][M];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph[Y][X] = true;
            }

            int cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (!graph[j][k] || visited[j][k]) {
                        continue;
                    }

                    Queue<Dot> queue = new LinkedList<>();
                    queue.add(new Dot(j, k));
                    while (!queue.isEmpty()) {
                        Dot cur = queue.poll();

                        for (int idx = 0; idx < 4; idx++) {
                            int newRow = cur.row + dRow[idx];
                            int newCol = cur.col + dCol[idx];
                            if (newRow < 0 || newRow > N - 1 || newCol < 0 || newCol > M - 1) {
                                continue;
                            }

                            if (!graph[newRow][newCol] || visited[newRow][newCol]) {
                                continue;
                            }

                            visited[newRow][newCol] = true;
                            queue.add(new Dot(newRow, newCol));
                        }
                    }
                    cnt++;
                }
            }
            System.out.println(cnt);
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