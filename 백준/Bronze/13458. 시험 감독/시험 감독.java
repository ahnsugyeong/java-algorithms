import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 시험장의 개수 입력
        int N = Integer.parseInt(br.readLine());

        // 각 시험장에 있는 응시자의 수
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // B: (총감독관) 한 시험자에서 감시할 수 있는 응시자의 수
        // C: (부감독관) 한 시험자에서 감시할 수 있는 응시자의 수
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long cnt = N;    // 총 감독관 한 명씩 배치
        for (int i = 0; i < N; i++) {
            numbers[i] -= B;
            if (numbers[i] > 0) {
                cnt += Math.ceil((double) numbers[i] / C);   // 부감독관 배치
            }
        }

        System.out.println(cnt);
    }

}
