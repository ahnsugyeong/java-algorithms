import java.util.*;
import java.io.*;

public class Main {

    public static char[][] candies = new char[50][50];
    public static int di[] = {0, 0, 1, -1};
    public static int dj[] = {1, -1, 0, 0};
    public static int max = 1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            candies[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int idx = 0; idx < 4; idx++) {
                    int new_i = i + di[idx];
                    int new_j = j + dj[idx];
                    if (new_i < 0 || new_i > N - 1 || new_j < 0 || new_j > N - 1) {
                        continue;
                    }
                    if (candies[i][j] == candies[new_i][new_j]) {
                        continue;
                    }
                    swap(i, j, new_i, new_j);
                    getMaxCandies(N);
                    swap(i, j, new_i, new_j);
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    public static void swap(int first_i, int first_j, int second_i, int second_j) {
        char tmp = candies[first_i][first_j];
        candies[first_i][first_j] = candies[second_i][second_j];
        candies[second_i][second_j] = tmp;
    }

    public static void getMaxCandies(int N) {
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (candies[i][j] == candies[i][j + 1]) {
                    cnt++;
                    max = Math.max(cnt, max);
                } else {
                    cnt = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (candies[j][i] == candies[j + 1][i]) {
                    cnt++;
                    max = Math.max(cnt, max);
                } else {
                    cnt = 1;
                }
            }
        }
    }

}
