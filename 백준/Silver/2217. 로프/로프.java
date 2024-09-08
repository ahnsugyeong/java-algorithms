import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] ropes = new int[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);

        // 특정 로프를 사용할 경우, 그 로프보다 무게가 큰 로프를 '모두' 사용하는 것이 이득
        // 최대 무게 w = ropes[i] * (N - i)
        int maxVal = 0;
        for (int i = 0; i < N; i++) {
            maxVal = Math.max(maxVal, ropes[i] * (N - i));
        }

        System.out.println(maxVal);
    }
}
