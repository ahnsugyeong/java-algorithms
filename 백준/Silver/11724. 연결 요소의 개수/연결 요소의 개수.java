import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 정점의 개수
        int M = Integer.parseInt(st.nextToken());   // 간선의 개수

        boolean[][] graph = new boolean[N + 1][N + 1];
        boolean[][] visitedEdges = new boolean[N + 1][N + 1];
        boolean[] visitedVertices = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true;
            graph[b][a] = true;
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (visitedVertices[i]) {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int j = 1; j <= N; j++) {
                    if (!graph[cur][j] || visitedEdges[cur][j] || visitedVertices[j]) {
                        continue;
                    }

                    visitedVertices[j] = true;
                    visitedEdges[cur][j] = true;
                    visitedEdges[j][cur] = true;
                    queue.add(j);
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }

}