import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int width = W / (N + 1);
        if (W % (N + 1) != 0) {
            width++;
        }

        int height = H / (M + 1);
        if (H % (M + 1) != 0) {
            height++;
        }

        System.out.println(width * height);
    }
}