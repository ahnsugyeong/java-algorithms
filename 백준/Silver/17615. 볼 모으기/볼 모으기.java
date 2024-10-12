import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int ans = Integer.MAX_VALUE;

        // 1. 빨간 공 왼쪽으로
        int cnt = 0;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            if (!flag && input.charAt(i) == 'B') {
                flag = true;
            }
            if (flag && input.charAt(i) == 'R') {
                cnt++;
            }
        }
        ans = Math.min(ans, cnt);

        // 2. 파란 공 왼쪽으로
        cnt = 0;
        flag = false;
        for (int i = 0; i < N; i++) {
            if (!flag && input.charAt(i) == 'R') {
                flag = true;
            }
            if (flag && input.charAt(i) == 'B') {
                cnt++;
            }
        }
        ans = Math.min(ans, cnt);

        // 3. 빨간 공 오른쪽으로
        cnt = 0;
        flag = false;
        for (int i = N - 1; i >= 0; i--) {
            if (!flag && input.charAt(i) == 'B') {
                flag = true;
            }
            if (flag && input.charAt(i) == 'R') {
                cnt++;
            }
        }
        ans = Math.min(ans, cnt);

        // 4. 파란 공 오른쪽으로
        cnt = 0;
        flag = false;
        for (int i = N - 1; i >= 0; i--) {
            if (!flag && input.charAt(i) == 'R') {
                flag = true;
            }
            if (flag && input.charAt(i) == 'B') {
                cnt++;
            }
        }
        ans = Math.min(ans, cnt);

        System.out.println(ans);
    }
}