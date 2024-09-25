import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] kids = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            kids[Integer.parseInt(st.nextToken())] = i;
        }

        // 가장 긴 증가하는 수열의 길이 계산
        int len = 1, maxLen = 1;
        for (int i = 2; i <= N; i++) {
            if (kids[i - 1] < kids[i]) {
                len++;
            } else {
                len = 1;
            }
            maxLen = Math.max(maxLen, len);
        }

        // 전체 길이에서 빼기
        System.out.println(N - maxLen);
    }

}