import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dice = {0, 0, 0, 0, 0, 0};    // 0: 아래, 1: 오른쪽, 2: 위, 3: 왼쪽, 4: 앞, 5: 뒤
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            String command = st.nextToken();
            if (command.equals("1")) {  // 동쪽
                if (y + 1 > M - 1) {
                    continue;
                }
                y++;

                int tmp = dice[0];
                dice[0] = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[3];
                dice[3] = tmp;

            } else if (command.equals("2")) {  // 서쪽
                if (y - 1 < 0) {
                    continue;
                }
                y--;

                int tmp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[2];
                dice[2] = dice[1];
                dice[1] = tmp;

            } else if (command.equals("3")) {  // 북쪽
                if (x - 1 < 0) {
                    continue;
                }
                x--;

                int tmp = dice[0];
                dice[0] = dice[5];
                dice[5] = dice[2];
                dice[2] = dice[4];
                dice[4] = tmp;
            } else if (command.equals("4")) {  // 남쪽
                if (x + 1 > N - 1) {
                    continue;
                }
                x++;

                int tmp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[2];
                dice[2] = dice[5];
                dice[5] = tmp;
            }

            if (map[x][y] == 0) {
                map[x][y] = dice[0];
            } else {
                dice[0] = map[x][y];
                map[x][y] = 0;
            }

            bw.write(String.valueOf(dice[2]));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

}