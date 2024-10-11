import java.io.*;
import java.util.*;

public class Main {

    static int N, M, V;
    static boolean[][] graph;
    static boolean[][] visitedEdges;
    static boolean[] visitedVertices;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 정점의 개수
        M = Integer.parseInt(st.nextToken());   // 간선의 개수
        V = Integer.parseInt(st.nextToken());   // 탐색을 시작할 정점의 번호

        graph = new boolean[N + 1][N + 1];
        visitedEdges = new boolean[N + 1][N + 1];
        visitedVertices = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start][end] = true;
            graph[end][start] = true;
        }

        visitedVertices[V] = true;
        DFS(0, V);
        System.out.println();

        init();
        BFS();
    }

    static void init() {
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visitedEdges[i], false);
        }
        Arrays.fill(visitedVertices, false);
    }

    static void DFS(int cnt, int idx) {
        System.out.print(idx + " ");
        if (cnt == N) {
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!graph[idx][i] || visitedEdges[idx][i] || visitedVertices[i]) {
                continue;
            }
            visitedEdges[idx][i] = true;
            visitedEdges[i][idx] = true;
            visitedVertices[i] = true;
            DFS(cnt + 1, i);
        }
    }

    static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);

        while (!queue.isEmpty()) {
            int idx = queue.poll();
            System.out.print(idx + " ");

            for (int i = 1; i <= N; i++) {
                if (!graph[idx][i] || visitedEdges[idx][i] || visitedVertices[i]) {
                    continue;
                }
                visitedEdges[idx][i] = true;
                visitedEdges[i][idx] = true;
                visitedVertices[i] = true;
                queue.add(i);
            }
        }
    }
}