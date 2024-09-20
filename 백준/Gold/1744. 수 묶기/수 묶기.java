import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        List<Integer> positiveNumbers = new ArrayList<>();
        List<Integer> negativeNumbers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            if (numbers[i] > 0) {
                positiveNumbers.add(numbers[i]);
            } else {
                negativeNumbers.add(numbers[i]);
            }
        }

        Collections.sort(positiveNumbers, Collections.reverseOrder());
        Collections.sort(negativeNumbers);

        int i = 0;
        int sum = 0;
        while (i < positiveNumbers.size()) {
            if (i + 1 < positiveNumbers.size() && positiveNumbers.get(i) != 1 && positiveNumbers.get(i + 1) != 1) {
                sum += (positiveNumbers.get(i) * positiveNumbers.get(i + 1));
                i += 2;
            } else {
                sum += positiveNumbers.get(i);
                i++;
            }
        }

        i = 0;
        while (i < negativeNumbers.size()) {
            if (i + 1 < negativeNumbers.size() && negativeNumbers.get(i) != 1 && negativeNumbers.get(i + 1) != 1) {
                sum += (negativeNumbers.get(i) * negativeNumbers.get(i + 1));
                i += 2;
            } else {
                sum += negativeNumbers.get(i);
                i++;
            }
        }

        System.out.println(sum);
    }
}