import java.util.*;
import java.io.*;

public class Main {

    static int[] colorArr = new int[4];
    static int[] numberArr = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int maxNumber = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char color = st.nextToken().charAt(0);
            int number = Integer.parseInt(st.nextToken());

            if (color == 'R') {
                colorArr[0]++;
            } else if (color == 'B') {
                colorArr[1]++;
            } else if (color == 'Y') {
                colorArr[2]++;
            } else if (color == 'G') {
                colorArr[3]++;
            }
            numberArr[number]++;
            maxNumber = Math.max(maxNumber, number);
        }

        int ans = 0;
        int number = 0;
        if (firstRule()) {
            ans = maxNumber + 900;
        } else if (secondRule()) {
            for (int i = 1; i < 10; i++) {
                if (numberArr[i] == 4) {
                    number = i;
                    break;
                }
            }
            ans = number + 800;
        } else if (thirdRule()) {
            int threeNumber = 0;
            int twoNumber = 0;
            for (int i = 0; i < 10; i++) {
                if (numberArr[i] == 3) {
                    threeNumber = i;
                } else if (numberArr[i] == 2) {
                    twoNumber = i;
                }
            }
            ans = threeNumber * 10 + twoNumber + 700;
        } else if (forthRule()) {
            ans = maxNumber + 600;
        } else if (fifthRule()) {
            ans = maxNumber + 500;
        } else if (sixthRule()) {
            for (int i = 0; i < 10; i++) {
                if (numberArr[i] == 3) {
                    number = i;
                    break;
                }
            }
            ans = number + 400;
        } else if (seventhRule()) {
            int number1 = 0;
            int number2 = 0;
            for (int i = 0; i < 10; i++) {
                if (number1 == 0 && numberArr[i] == 2) {
                    number1 = i;
                } else if (numberArr[i] == 2) {
                    number2 = i;
                }
            }
            if (number1 < number2) {
                int tmp = number1;
                number1 = number2;
                number2 = tmp;
            }
            ans = number1 * 10 + number2 + 300;
        } else if (eighthRule()) {
            for (int i = 0; i < 10; i++) {
                if (numberArr[i] == 2) {
                    number = i;
                    break;
                }
            }
            ans = number + 200;
        } else {
            ans = maxNumber + 100;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    static boolean firstRule() {
        int sameColorCnt = 0;
        for (int i = 0; i < 4; i++) {
            sameColorCnt = Math.max(sameColorCnt, colorArr[i]);
        }

        int continuousNumberCnt = 0;
        int tmp = 1;
        for (int i = 1; i <= 9; i++) {
            if (numberArr[i] == 1 && i < 9 && numberArr[i + 1] == 1) {
                tmp++;
            } else {
                continuousNumberCnt = Math.max(continuousNumberCnt, tmp);
                tmp = 1;
            }
        }

        return sameColorCnt == 5 && continuousNumberCnt == 5;
    }

    static boolean secondRule() {
        int sameNumberCnt = 0;
        for (int i = 0; i < 10; i++) {
            sameNumberCnt = Math.max(sameNumberCnt, numberArr[i]);
        }
        return sameNumberCnt == 4;
    }

    static boolean thirdRule() {
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < 10; i++) {
            if (numberArr[i] == 3) {
                flag1 = true;
            } else if (numberArr[i] == 2) {
                flag2 = true;
            }
        }
        return flag1 && flag2;
    }

    static boolean forthRule() {
        int sameColorCnt = 0;
        for (int i = 0; i < 4; i++) {
            sameColorCnt = Math.max(sameColorCnt, colorArr[i]);
        }
        return sameColorCnt == 5;
    }

    static boolean fifthRule() {
        int continuousNumberCnt = 0;
        int tmp = 1;
        for (int i = 1; i <= 9; i++) {
            if (numberArr[i] == 1 && i < 9 && numberArr[i + 1] == 1) {
                tmp++;
            } else {
                continuousNumberCnt = Math.max(continuousNumberCnt, tmp);
                tmp = 1;
            }
        }
        continuousNumberCnt = Math.max(continuousNumberCnt, tmp);
        return continuousNumberCnt == 5;
    }

    static boolean sixthRule() {
        int sameNumberCnt = 0;
        for (int i = 0; i < 10; i++) {
            sameNumberCnt = Math.max(sameNumberCnt, numberArr[i]);
        }
        return sameNumberCnt == 3;
    }

    static boolean seventhRule() {
        int firstPair = -1;
        int secondPair = -1;
        for (int i = 1; i < 10; i++) {
            if (numberArr[i] == 2) {
                if (firstPair == -1) {
                    firstPair = i;
                } else {
                    secondPair = i;
                    break;
                }
            }
        }
        return firstPair != -1 && secondPair != -1;
    }

    static boolean eighthRule() {
        int sameNumberCnt = 0;
        for (int i = 0; i < 10; i++) {
            sameNumberCnt = Math.max(sameNumberCnt, numberArr[i]);
        }
        return sameNumberCnt == 2;
    }

}