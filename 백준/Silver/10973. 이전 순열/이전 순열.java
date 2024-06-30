import java.util.*;
import java.io.*;

public class Main {

    public static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (nextPermutation()) {
            for (int i = 0; i < N; i++) {
                bw.write(numbers[i] + " ");
            }
        } else {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
    }

    public static boolean nextPermutation() {
        int i = numbers.length - 1;
        while (i > 0 && numbers[i - 1] <= numbers[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }

        int j = numbers.length - 1;
        while (numbers[j] >= numbers[i - 1]) {
            j--;
        }
        swap(i - 1, j);

        j = numbers.length - 1;
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }

    public static void swap(int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }


}