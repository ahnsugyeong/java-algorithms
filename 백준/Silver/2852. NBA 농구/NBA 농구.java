import java.util.*;
import java.io.*;

public class Main {

    static int[] firstTeam = new int[2881];
    static int[] secondTeam = new int[2881];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String teamNumber = st.nextToken();
            int time = convertTimeStringToInt(st.nextToken());
            if (teamNumber.equals("1")) {
                for (int j = time; j <= 2880; j++) {
                    firstTeam[j]++;
                }
            } else if (teamNumber.equals("2")) {
                for (int j = time; j <= 2880; j++) {
                    secondTeam[j]++;
                }
            }
        }

        int firstCnt = 0;
        int secondCnt = 0;
        for (int i = 0; i < 2880; i++) {
            if (firstTeam[i] > secondTeam[i]) {
                firstCnt++;
            } else if (firstTeam[i] < secondTeam[i]) {
                secondCnt++;
            }
        }

        bw.write(convertTimeIntToString(firstCnt));
        bw.newLine();
        bw.write(convertTimeIntToString(secondCnt));

        bw.flush();
        bw.close();
    }

    static int convertTimeStringToInt(String input) {
        int minute = Integer.parseInt(input.substring(0, 2));
        int second = Integer.parseInt(input.substring(3, 5));
        return minute * 60 + second;
    }

    static String convertTimeIntToString(int input) {
        StringBuilder sb = new StringBuilder();
        if (input / 60 < 10) {
            sb.append("0");
        }
        sb.append(input / 60);
        sb.append(":");
        if (input % 60 < 10) {
            sb.append("0");
        }
        sb.append(input % 60);
        return sb.toString();
    }

}