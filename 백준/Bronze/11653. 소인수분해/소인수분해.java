import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N > 1) {
            int number = N;
            for (int i = 2; i <= number; i++) {
                if (N % i == 0) {
                    number = i;
                    break;
                }
            }
            System.out.println(number);
            N /= number;
        }
    }

}
