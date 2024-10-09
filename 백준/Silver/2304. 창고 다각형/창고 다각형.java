import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] polygon;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        polygon = new int[N][2];
        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            polygon[i][0] = Integer.parseInt(st.nextToken());
            polygon[i][1] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, polygon[i][1]);
        }

        Arrays.sort(polygon, new IndexComparator());

        int i = 0, area = 0;
        while (i < N - 1) {
            int higherIdx = getHigherIdx(i);
            if (higherIdx > -1) {
                area += (polygon[higherIdx][0] - polygon[i][0]) * polygon[i][1];
                i = higherIdx;
            } else {
                int maxIdx = getMaxIdx(i);
                area += (polygon[maxIdx][0] - polygon[i][0]) * polygon[maxIdx][1];
                i = maxIdx;
            }
        }
        System.out.println(area + maxHeight);
    }

    static int getMaxIdx(int idx) {
        int maxHeight = 0;
        int maxIdx = 0;
        for (int i = idx + 1; i < N; i++) {
            if (polygon[i][1] > maxHeight) {
                maxHeight = polygon[i][1];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    static int getHigherIdx(int idx) {
        for (int i = idx + 1; i < N; i++) {
            if (polygon[i][1] > polygon[idx][1]) {
                return i;
            } else {
            }
        }
        return -1;
    }

    static class IndexComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
        }

    }

}