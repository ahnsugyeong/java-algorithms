import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, new MeetingTimeComparator());

        int cnt = 0, tmp = 0;
        for (int i = 0; i < N; i++) {
            int startTime = meetings[i][0];
            int endTime = meetings[i][1];

            if (tmp <= startTime) {
                cnt++;
                tmp = endTime;
            }
        }

        System.out.println(cnt);
    }

    static class MeetingTimeComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] a, int[] b) {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        }

    }
}
