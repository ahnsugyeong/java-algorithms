import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        List<Integer> numbers = new ArrayList<>();
        while (st.hasMoreTokens()) {
            int number = getSum(st.nextToken());
            numbers.add(number);
        }

        int ans = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            ans -= numbers.get(i);
        }
        System.out.println(ans);
    }

    public static int getSum(String str) {
        int sum = 0;
        int number = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+') {
                sum += number;
                number = 0;
            } else {
                number = number * 10 + (str.charAt(i) - '0');
            }
        }
        sum += number;
        return sum;
    }
}
