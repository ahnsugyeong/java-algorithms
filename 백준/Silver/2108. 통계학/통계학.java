import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            sum += number;
            numbers.add(number);
        }
        numbers.sort(Comparator.naturalOrder());
        int maxValue = numbers.get(numbers.size() - 1);
        int minValue = numbers.get(0);

        bw.write(String.valueOf(Math.round((double) sum / N)));
        bw.newLine();
        bw.write(String.valueOf(numbers.get(N / 2)));
        bw.newLine();
        bw.write(String.valueOf(findSecondSmallestMode(numbers)));
        bw.newLine();
        bw.write(String.valueOf(maxValue - minValue));



        bw.flush();
        bw.close();
    }

    public static int findSecondSmallestMode(List<Integer> numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : numbers) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        int maxFrequency = Collections.max(map.values());

        List<Integer> modeValues = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modeValues.add(entry.getKey());
            }
        }

        Collections.sort(modeValues);

        if (modeValues.size() > 1) {
            return modeValues.get(1);
        } else {
            return modeValues.get(0);
        }
    }

}
