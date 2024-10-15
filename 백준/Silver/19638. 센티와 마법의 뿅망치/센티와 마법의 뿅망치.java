import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        for (int i = 0; i < T; i++) {
            int cur = pq.poll();

            if (cur > 1) {
                pq.add(cur / 2);
            } else {
                pq.add(cur);
            }

            if (cur >= H) {
                cnt++;
            }
        }

        boolean flag = true;
        int maxH = 0;
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (maxH == 0) {
                maxH = cur;
            }
            if (cur >= H) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("YES");
            System.out.println(cnt);
        } else {
            System.out.println("NO");
            System.out.println(maxH);
        }
    }

}