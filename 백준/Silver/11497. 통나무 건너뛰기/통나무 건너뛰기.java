import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Integer[] arr = new Integer[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, Collections.reverseOrder());

            Deque<Integer> dq = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    dq.addFirst(arr[i]);
                } else {
                    dq.addLast(arr[i]);
                }
            }

            int first = dq.poll();
            int level = 0;
            int cur = first, prev = first;
            for (int i = 1; i < N; i++) {
                prev = cur;
                cur = dq.poll();
                level = Math.max(level, Math.abs(prev - cur));
            }
            level = Math.max(level, Math.abs(first - cur));

            System.out.println(level);
        }


    }
}