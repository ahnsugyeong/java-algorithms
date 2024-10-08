import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0, cnt = 0;
        while (true) {
            if (sum == M) {
                cnt++;
                sum -= A[start++];
            } else if (sum > M) {
                sum -= A[start++];
            } else if (end < N) {
                sum += A[end++];
            } else {
                break;
            }
        }
        System.out.println(cnt);
    }

}