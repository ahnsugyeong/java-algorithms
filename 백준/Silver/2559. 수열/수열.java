import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 첫 번째 윈도우 내의 합 계산
        int start = 0, end = K, sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }

        int maxSum = sum;
        while (true) {
            if (end == N) {
                break;
            }
            
            // 한 칸씩 윈도우 이동
            sum -= arr[start++];
            sum += arr[end++];
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }

}