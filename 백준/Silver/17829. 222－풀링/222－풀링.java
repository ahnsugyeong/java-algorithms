import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] table = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < getCount(N); i++) {
            table = pooling(table);
        }

        bw.write(String.valueOf(table[0][0]));
        bw.flush();
        bw.close();
    }

    public static int getCount(int N) {
        int cnt = 0;
        while (N / 2 > 0) {
            N /= 2;
            cnt++;
        }
        return cnt;
    }

    public static int[][] pooling(int[][] table) {
        int newSize = table.length / 2;
        int[][] newTable = new int[newSize][newSize];
        for (int i = 0; i < table.length; i += 2) {
            for (int j = 0; j < table.length; j += 2) {
                List<Integer> numbers = new ArrayList<>();
                numbers.add(table[i][j]);
                numbers.add(table[i][j + 1]);
                numbers.add(table[i + 1][j]);
                numbers.add(table[i + 1][j + 1]);
                numbers.sort(Comparator.reverseOrder());

                int maxVal = numbers.get(1);
                newTable[i / 2][j / 2] = maxVal;
            }
        }
        return newTable;
    }

}