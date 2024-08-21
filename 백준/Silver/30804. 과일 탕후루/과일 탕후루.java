import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] fruits = new int[N];
        int[] fruitCnt = new int[200001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int maxLength = 0;
        int left = 0, right = 0;
        int kind = 0;
        while (right < N) {
            if (fruitCnt[fruits[right]] == 0) {
                kind++;
            }
            fruitCnt[fruits[right]]++;

            if (kind > 2) {
                fruitCnt[fruits[left]]--;
                if (fruitCnt[fruits[left]] == 0) {
                    kind--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        bw.write(String.valueOf(maxLength));
        bw.flush();
        bw.close();
    }

}