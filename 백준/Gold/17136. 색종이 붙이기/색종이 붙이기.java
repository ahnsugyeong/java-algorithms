import java.io.*;
import java.util.*;

public class Main {

    static int[][] paper;
    static int[] remainCnt;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        paper = new int[10][10];
        remainCnt = new int[]{0, 5, 5, 5, 5, 5};
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0, 0);

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        
        System.out.println(ans);
    }

    public static void DFS(int i, int j, int cnt) {
        // 종이의 끝에 도달하면 최솟값 갱신 후 함수 종료
        if (i == 9 && j == 10) {
            ans = Math.min(ans, cnt);
            return;
        }

        // j가 끝에 도달하면 다음 줄로 이동
        if (j == 10) {
            DFS(i + 1, 0, cnt);
            return;
        }

        // 최솟값보다 cnt가 커지면 함수 종료
        if (cnt >= ans) {
            return;
        }

        if (paper[i][j] == 1) {
            for (int size = 5; size >= 1; size--) {
                if (isAvailable(i, j, size) && remainCnt[size] > 0) {
                    attach(i, j, size);
                    remainCnt[size]--;
                    DFS(i, j + 1, cnt + 1);
                    detach(i, j, size);
                    remainCnt[size]++;
                }
            }
        } else {
            DFS(i, j + 1, cnt);
        }


    }

    public static void attach(int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                paper[i][j] = 2;
            }
        }
    }

    public static void detach(int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                paper[i][j] = 1;
            }
        }
    }

    public static boolean isAvailable(int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (i >= 10 || j >= 10 || paper[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}