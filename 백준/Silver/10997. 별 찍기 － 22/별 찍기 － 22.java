import java.io.*;

public class Main {

    static int dir = 0;    // 0: 서, 1: 남, 2: 동, 3: 북
    static int[] dCol = {0, 1, 0, -1};
    static int[] dRow = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean[][] star = new boolean[N * 4 - 1][N * 4 - 3];

        int curCol = 0;
        int curRow = N * 4 - 4;
        star[curCol][curRow] = true;
        for (int i = 0; i < N * 4 - 2; i++) {
            while (true) {
                int newCol = curCol + dCol[dir];
                int newRow = curRow + dRow[dir];
                if (newCol < 0 || newCol > N * 4 - 2 || newRow < 0 || newRow > N * 4 - 4) {
                    break;
                }

                if (newCol + dCol[dir] >= 0 && newCol + dCol[dir] <= N * 4 - 2 && newRow + dRow[dir] >= 0 && newRow + dRow[dir] <= N * 4 - 4) {
                    if (star[newCol + dCol[dir]][newRow + dRow[dir]]) {
                        break;
                    }
                }

                star[newCol][newRow] = true;

                // 좌표 갱신
                curCol = newCol;
                curRow = newRow;
            }
            nextDir();
        }

        if (N == 1) {
            bw.write("*");
        } else {
            for (int i = 0; i < N * 4 - 1; i++) {
                if (i == 1) {
                    bw.write("*");
                } else {
                    for (int j = 0; j < N * 4 - 3; j++) {
                        if (star[i][j]) {
                            bw.write("*");
                        } else {
                            bw.write(" ");
                        }
                    }
                }

                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }

    public static void nextDir() {
        dir = (dir + 1) % 4;
    }

}

/*
N = 1
1 * 1

N = 2 -> 6번
7 * 5

N = 3 -> 10번
11 * 9

N = 4 -> 14번
15 * 13

(N * 4 - 2)번
크기: (N * 4 - 1, N * 4 - 3)

 */