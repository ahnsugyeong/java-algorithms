import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    static int N;
    static int[][] problems;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        problems = new int[N][2];   // 0: 데드라인, 1: 컵라면 수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            problems[i][0] = Integer.parseInt(st.nextToken());
            problems[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(problems, new DeadlineComparator());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(problems[i][1]);
            if (pq.size() > problems[i][0]) {
                pq.poll();
            }
        }

        int cnt = 0;
        while (!pq.isEmpty()) {
            cnt += pq.poll();
        }

        System.out.println(cnt);
    }


    static class DeadlineComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] a, int[] b) {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        }
    }

}
