import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;

        // 투 포인터 탐색 시작
        while (true) {
            if (sum >= S) {
                // 조건을 만족하면 최소 길이를 갱신하고, start를 오른쪽으로 이동
                minLen = Math.min(minLen, end - start);
                sum -= arr[start++];
            } else if (end == N) {
                // end가 배열 끝에 도달하면 종료
                break;
            } else {
                // sum < S이면 end를 오른쪽으로 이동
                sum += arr[end++];
            }
        }

        // 조건을 만족하는 부분합이 없을 경우 0 출력
        if (minLen == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(minLen);
        }
    }

}
