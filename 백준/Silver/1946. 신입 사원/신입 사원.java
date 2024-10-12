import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] applies = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                applies[i][0] = Integer.parseInt(st.nextToken());
                applies[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(applies, (a, b) -> Integer.compare(a[0], b[0]));

            int cnt = 1;    // 정렬 후 첫 번째 지원자는 무조건 선발
            int minInterviewRank = applies[0][1];
            for (int i = 1; i < N; i++) {
                if (minInterviewRank > applies[i][1]) {
                    cnt++;
                    minInterviewRank = applies[i][1];
                }
            }

            System.out.println(cnt);
        }
    }

}