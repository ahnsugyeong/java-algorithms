import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Integer>[] graph;  // 인접 리스트로 변경
    static boolean[] visited;
    static int[] parentNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];  // 인접 리스트 초기화
        visited = new boolean[N + 1];
        parentNumbers = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        DFS(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parentNumbers[i]);
        }
    }

    static void DFS(int node) {
        visited[node] = true;

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                parentNumbers[neighbor] = node;  // 부모 노드 저장
                DFS(neighbor);  // 재귀 호출
            }
        }
    }
}
