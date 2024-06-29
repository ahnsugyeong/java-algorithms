import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<BaseballGameInfo> baseballGameInfos = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            baseballGameInfos.add(new BaseballGameInfo(number, strike, ball));
        }

        int answerCnt = 0;
        for (int i = 111; i <= 999; i++) {
            if (containsZero(i) || hasDuplicateDigits(i)) {
                continue;
            }
            boolean isAnswer = true;
            for (int j = 0; j < N; j++) {
                BaseballGameInfo cur = baseballGameInfos.get(j);
                if (calculateStrike(i, cur.number) != cur.strike || calculateBall(i, cur.number) != cur.ball) {
                    isAnswer = false;
                    break;
                }
            }
            if (isAnswer) {
                answerCnt++;
            }
        }

        bw.write(String.valueOf(answerCnt));
        bw.flush();
        bw.close();
    }

    static class BaseballGameInfo {
        int number;
        int strike;
        int ball;

        BaseballGameInfo(int number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }

    public static int calculateStrike(int answer, int number) {
        int cnt = 0;
        if (answer % 10 == number % 10) {
            cnt++;
        }
        if (answer / 10 % 10 == number / 10 % 10) {
            cnt++;
        }
        if (answer / 100 % 10 == number / 100 % 10) {
            cnt++;
        }
        return cnt;
    }

    public static int calculateBall(int answer, int number) {
        int cnt = 0;
        int[] answerDigits = {answer % 10, (answer / 10) % 10, (answer / 100) % 10};
        int[] numberDigits = {number % 10, (number / 10) % 10, (number / 100) % 10};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && answerDigits[i] == numberDigits[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static boolean containsZero(int number) {
        return Integer.toString(number).contains("0");
    }

    public static boolean hasDuplicateDigits(int number) {
        int[] digitCount = new int[10];
        while (number > 0) {
            int digit = number % 10;
            if (digitCount[digit] > 0) {
                return true;
            }
            digitCount[digit]++;
            number /= 10;
        }
        return false;
    }
}
