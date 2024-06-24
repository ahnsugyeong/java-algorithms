import java.util.*;
import java.io.*;

public class Main {

    public static int ground[][] = new int[501][501];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                if (minValue > ground[i][j]) {
                    minValue = ground[i][j];
                }
                if (maxValue < ground[i][j]) {
                    maxValue = ground[i][j];
                }
            }
        }

        List<GroundInfo> groundInfos = new ArrayList<>();
        int height = minValue;
        while (height <= maxValue) {
            int time = getTimeOfLevelingGround(N, M, B, height);
            if (time != -1) {
                groundInfos.add(new GroundInfo(time, height));
            }
            height++;
        }

        groundInfos.sort(new GroundInfoComparator());
        GroundInfo ans = groundInfos.get(0);
        bw.write(ans.time + " " + ans.height);

        bw.flush();
        bw.close();
    }

    public static int getTimeOfLevelingGround(int N, int M, int B, int height) {
        int positive = 0;
        int negative = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ground[i][j] > height) {
                    positive += (ground[i][j] - height);
                } else if (ground[i][j] < height) {
                    negative += (height - ground[i][j]);
                }
            }
        }

        if (positive + B < negative) {
            return -1;
        }
        return positive * 2 + negative;
    }

    static class GroundInfo {
        int time;
        int height;

        GroundInfo(int time, int height) {
            this.time = time;
            this.height = height;
        }
    }

    static class GroundInfoComparator implements Comparator<GroundInfo> {

        @Override
        public int compare(GroundInfo g1, GroundInfo g2) {
            if (g1.time == g2.time) {
                return Integer.compare(g2.height, g1.height);
            }
            return Integer.compare(g1.time, g2.time);
        }
    }

}
