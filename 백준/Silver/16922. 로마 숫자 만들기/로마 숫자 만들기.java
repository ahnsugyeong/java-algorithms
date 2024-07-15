import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] romeNumber = {1, 5, 10, 50};
    static Set<Integer> numberSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        DFS(0, 0, 0);
        bw.write(String.valueOf(numberSet.size()));

        bw.flush();
        bw.close();
    }

    public static void DFS(int number, int cnt, int index) {
        if (cnt == N) {
            if (!numberSet.contains(number)) {
                numberSet.add(number);
            }
            return;
        }

        for (int i = index; i < 4; i++) {
            DFS(number + romeNumber[i], cnt + 1, i);
        }
    }

}