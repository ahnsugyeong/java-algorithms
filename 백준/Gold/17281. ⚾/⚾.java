import java.io.*;
import java.util.*;

public class Main {

    static int N, ans;
    static boolean[] visited;
    static int[] hitter;    // key: 타순, value: 선수 번호
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        visited = new boolean[10];
        hitter = new int[10];
        ans = 0;

        N = Integer.parseInt(br.readLine());
        result = new int[N + 1][10];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(1);

        System.out.println(ans);
    }

    public static void DFS(int cnt) {
        // 4번 타자는 1번으로 고정
        if (cnt == 4) {
            visited[1] = true;
            hitter[4] = 1;
            DFS(cnt + 1);
        }

        // 9명 타순 결정되면 경기 시작
        if (cnt == 10) {
            int score = playBall();
            ans = Math.max(ans, score);
            return;
        }

        for (int i = 2; i <= 9; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            hitter[cnt] = i;
            DFS(cnt + 1);
            visited[i] = false;
        }
    }

    public static int playBall() {
        int score = 0;
        int curHitterIdx = 1;
        for (int inning = 1; inning <= N; inning++) {
            int outCount = 0;
            boolean[] base = new boolean[4];
            while (outCount < 3) {
                int curHitter = hitter[curHitterIdx];
                int hitResult = result[inning][curHitter];

                curHitterIdx = (curHitterIdx % 9) + 1;

                switch (hitResult) {
                    case 0: {
                        outCount++;
                        break;
                    }
                    case 1: {
                        // 안타: 타자와 모든 주자가 한 루씩 진루
                        if (base[3]) {
                            score++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            base[2] = false;
                            base[3] = true;
                        }
                        if (base[1]) {
                            base[1] = false;
                            base[2] = true;
                        }
                        base[1] = true;
                        break;
                    }
                    case 2: {
                        // 2루타: 타자와 모든 주자가 두 루씩 진루
                        if (base[3]) {
                            score++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            score++;
                            base[2] = false;
                        }
                        if (base[1]) {
                            base[1] = false;
                            base[3] = true;
                        }
                        base[2] = true;
                        break;
                    }
                    case 3: {
                        // 3루타: 타자와 모든 주자가 세 루씩 진루
                        if (base[3]) {
                            score++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            score++;
                            base[2] = false;
                        }
                        if (base[1]) {
                            score++;
                            base[1] = false;
                        }
                        base[3] = true;
                        break;
                    }
                    case 4: {
                        // 홈런: 타자와 모든 주자가 홈까지 진루
                        if (base[3]) {
                            score++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            score++;
                            base[2] = false;
                        }
                        if (base[1]) {
                            score++;
                            base[1] = false;
                        }
                        score++;
                        break;
                    }
                }
            }
        }
        return score;
    }
}