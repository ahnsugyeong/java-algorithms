import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] lengths = new int[3];
            for (int i = 0; i < 3; i++) {
                lengths[i] = Integer.parseInt(st.nextToken());
            }
            if (lengths[0] == 0 && lengths[1] == 0 && lengths[2] == 0) {
                break;
            }
            Arrays.sort(lengths);
            print(lengths);
        }
    }

    public static void print(int[] lengths) {
        if (lengths[2] >= lengths[0] + lengths[1]) {
            System.out.println("Invalid");
            return;
        }

        int cnt = 0;
        for (int i = 0; i < 2; i++) {
            if (lengths[i] == lengths[i + 1]) {
                cnt++;
            }
        }

        if (cnt == 2) {
            System.out.println("Equilateral");
        } else if (cnt == 1) {
            System.out.println("Isosceles");
        } else {
            System.out.println("Scalene");
        }
    }
}