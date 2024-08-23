import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N + 1][N + 1];  // 1: 뱀, 2: 사과

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            board[col][row] = 2;    // 사과
        }

        int L = Integer.parseInt(br.readLine());
        Map<Integer, String> commands = new HashMap<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            commands.put(X, C);
        }

        int time = 0;
        int dir = 0;    // 0: 동, 1: 남, 2: 서, 3: 북
        int[] dCol = {0, 1, 0, -1};
        int[] dRow = {1, 0, -1, 0};
        board[1][1] = 1;    // 초기 뱀 위치

        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{1, 1});

        while (true) {
            // 새로운 머리 위치 계산
            int[] head = snake.getFirst();
            int headCol = head[0] + dCol[dir];
            int headRow = head[1] + dRow[dir];
            time++;

            // 뱀의 몸이나 벽에 부딪힌 경우 게임 종료
            if (headCol < 1 || headCol > N || headRow < 1 || headRow > N || board[headCol][headRow] == 1) {
                break;
            }

            if (board[headCol][headRow] == 2) { // // 사과가 있는 경우
                board[headCol][headRow] = 1;
                snake.addFirst(new int[]{headCol, headRow});
            } else {    // 사과가 없는 경우
                board[headCol][headRow] = 1;
                snake.addFirst(new int[]{headCol, headRow});
                int[] tail = snake.removeLast();    // 꼬리 제거
                board[tail[0]][tail[1]] = 0;
            }

            // 방향 전환
            if (commands.containsKey(time)) {
                String command = commands.get(time);
                dir = changeDir(dir, command);
            }
        }

        bw.write(String.valueOf(time));
        br.close();
        bw.flush();
        bw.close();
    }

    public static int changeDir(int dir, String command) {
        if (command.equals("L")) {  // 왼쪽으로 90도 회전
            return (dir + 3) % 4;
        } else if (command.equals("D")) {   // 오른쪽으로 90도 회전
            return (dir + 1) % 4;
        }
        throw new IllegalArgumentException("command error");
    }

}