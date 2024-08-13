import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] numbers = br.readLine().split(" ");
        int number = getClockNumber(numbers);
        int cnt = 0;
        for (int i = 1111; i <= 9999; i++) {
            if (!isClockNumber(i)) {
                continue;
            }
            cnt++;
            if (number == i) {
                break;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    public static int getClockNumber(String[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            sb.append(number);
        }

        int rotation1 = Integer.parseInt(sb.toString());
        int rotation2 = rotation1 % 1000 * 10 + rotation1 / 1000;
        int rotation3 = rotation1 % 100 * 100 + rotation1 / 100;
        int rotation4 = rotation1 % 10 * 1000 + rotation1 / 10;

        return Math.min(rotation1, Math.min(rotation2, Math.min(rotation3, rotation4)));
    }

    public static boolean isClockNumber(int n) {
        String str = String.valueOf(n);
        int rotation1 = Integer.parseInt(str);
        int rotation2 = rotation1 % 1000 * 10 + rotation1 / 1000;
        int rotation3 = rotation1 % 100 * 100 + rotation1 / 100;
        int rotation4 = rotation1 % 10 * 1000 + rotation1 / 10;

        int minRotation = Math.min(Math.min(rotation1, rotation2), Math.min(rotation3, rotation4));
        return minRotation == n;
    }

}