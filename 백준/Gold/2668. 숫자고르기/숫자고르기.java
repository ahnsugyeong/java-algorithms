import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] numbers;
    static boolean[] visited;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        // 노드마다 사이클 발생 여부 체크
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            DFS(i, i);
            visited[i] = false;
        }

        System.out.println(result.size());
        for (int number : result) {
            System.out.println(number);
        }

    }

    static void DFS(int start, int target) {
        if (numbers[start] == target) {
            result.add(numbers[start]);
        }

        if (visited[numbers[start]]) {
            return;
        }
        
        visited[numbers[start]] = true;
        DFS(numbers[start], target);
        visited[numbers[start]] = false;

    }
}