import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(N, 0));
        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            visited[cur.idx] = true;

            if (cur.idx == K) {
                System.out.println(cur.time);
                return;
            }

            if (cur.idx + 1 <= 100000 && !visited[cur.idx + 1]) {
                queue.add(new Pos(cur.idx + 1, cur.time + 1));
                visited[cur.idx + 1] = true;

                if (cur.idx + 1 == K) {
                    System.out.println(cur.time + 1);
                    return;
                }
            }

            if (cur.idx - 1 >= 0 && !visited[cur.idx - 1]) {
                queue.add(new Pos(cur.idx - 1, cur.time + 1));
                visited[cur.idx - 1] = true;

                if (cur.idx - 1 == K) {
                    System.out.println(cur.time + 1);
                    return;
                }
            }

            if (cur.idx * 2 <= 100000 && !visited[cur.idx * 2]) {
                queue.add(new Pos(cur.idx * 2, cur.time + 1));
                visited[cur.idx * 2] = true;

                if (cur.idx * 2 == K) {
                    System.out.println(cur.time + 1);
                    return;
                }
            }
        }

    }

    static class Pos {
        int idx;
        int time;

        public Pos(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }

}