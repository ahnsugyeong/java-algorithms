import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i = N - 1; i > 0; i--) {
            if (scores[i] <= scores[i - 1]) {
                int gap = scores[i - 1] - scores[i] + 1;
                cnt += gap;
                scores[i - 1] -= gap;
            }
        }

        System.out.println(cnt);
    }
}