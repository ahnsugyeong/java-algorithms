import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] prices = new int[N];
            for (int j = 0; j < N; j++) {
                prices[j] = Integer.parseInt(st.nextToken());
            }

            long maxProfit = 0;
            int maxPrice = 0;
            // 뒤에서부터 최대 가격을 갱신하며 이익 계산
            for (int j = N - 1; j >= 0; j--) {
                if (prices[j] > maxPrice) {
                    maxPrice = prices[j]; // 미래의 최대 가격 갱신
                } else {
                    maxProfit += maxPrice - prices[j]; // 이익 계산
                }
            }

            System.out.println(maxProfit);
        }
    }
}
