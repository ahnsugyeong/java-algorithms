import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] town;
    static boolean[][] visited;
    static int[] dRow = {0, 0, 1, -1};
    static int[] dCol = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        town = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                town[i][j] = input.charAt(j) - '0';
            }
        }

        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (town[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                counts.add(BFS(i, j));
            }
        }

        Collections.sort(counts);

        System.out.println(counts.size());
        for (int cnt : counts) {
            System.out.println(cnt);
        }
    }

    static int BFS(int i, int j) {
        Queue<Dot> queue = new LinkedList<>();
        queue.add(new Dot(i, j));
        visited[i][j] = true;

        int cnt = 0;
        while (!queue.isEmpty()) {
            Dot cur = queue.poll();
            cnt++;

            for (int idx = 0; idx < 4; idx++) {
                int newRow = cur.row + dRow[idx];
                int newCol = cur.col + dCol[idx];

                if (newRow < 0 || newRow > N - 1 || newCol < 0 || newCol > N - 1) {
                    continue;
                }

                if (town[newRow][newCol] == 0 || visited[newRow][newCol]) {
                    continue;
                }

                visited[newRow][newCol] = true;
                queue.add(new Dot(newRow, newCol));
            }
        }
        return cnt;
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