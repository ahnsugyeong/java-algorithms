import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            numbers.add(number);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = N; i >= 1; i--) {
            ans.add(numbers.get(i - 1), i);
        }

        for(int number: ans) {
            bw.write(number + " ");
        }

        bw.flush();
        bw.close();
    }

}