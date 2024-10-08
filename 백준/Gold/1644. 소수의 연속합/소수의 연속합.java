import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> primeNumbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        savePrimeNumber(N);

        int start = 0, end = 0, sum = 0, cnt = 0;
        while (true) {
            if (sum == N) {
                cnt++;
                sum -= primeNumbers.get(start++);
            } else if (sum > N) {
                sum -= primeNumbers.get(start++);
            } else if (end < primeNumbers.size()) {
                sum += primeNumbers.get(end++);
            } else {
                break;
            }
        }

        System.out.println(cnt);
    }

    static void savePrimeNumber(int N) {
        boolean[] isPrimeNumber = new boolean[N + 1];
        Arrays.fill(isPrimeNumber, true);

        for (int i = 2; i <= N; i++) {
            for (int j = i * 2; j <= N; j += i) {
                isPrimeNumber[j] = false;
            }
        }

        for (int i = 2; i <= N; i++) {
            if (isPrimeNumber[i]) {
                primeNumbers.add(i);
            }
        }
    }

}