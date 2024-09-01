import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] gifticons = new int[N][2];  // 0: 남은 기한, 1: 사용 계획일
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            gifticons[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            gifticons[i][1] = Integer.parseInt(st.nextToken());
        }

        // 사용 계획일 기준으로 오름차순 정렬
        Arrays.sort(gifticons, new GifticonComparator());

        int previous = gifticons[0][1];
        int currentMax = -1;
        long answer = 0;

        for (int i = 0; i < N; i++) {
            if (previous > gifticons[i][0]) {
                previous = Math.max(previous, gifticons[i][1]);

                int cnt = (int) Math.ceil((previous - gifticons[i][0]) / 30.0);
                gifticons[i][0] += cnt * 30;
                answer += cnt;
            }

            currentMax = Math.max(currentMax, gifticons[i][0]);

            if (i + 1 < N && gifticons[i][1] != gifticons[i + 1][1]) {
                previous = currentMax;
            }
        }
        
        System.out.println(answer);
    }

    static class GifticonComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] a, int[] b) {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        }
    }
}
