import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int ans = 1;
        if (N == 1) {
            ans = 1;
        } else if (N == 2) {
            ans = Math.min((M + 1) / 2, 4);
        } else if (N >= 3) {
            if (M < 7) {
                ans = Math.min(M, 4);
            } else {
                ans = M - 2;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}