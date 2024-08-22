import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Bead {
        int redCol;
        int redRow;
        int blueCol;
        int blueRow;
        int cnt;

        public Bead(int redCol, int redRow, int blueCol, int blueRow, int cnt) {
            this.redCol = redCol;
            this.redRow = redRow;
            this.blueCol = blueCol;
            this.blueRow = blueRow;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] toy = new int[N][M];    // 0: 빈 칸, 1: 벽, 2: 구멍
        boolean[][][][] visited = new boolean[N][M][N][M];
        int redCol = 0, redRow = 0, blueCol = 0, blueRow = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == '#') {
                    toy[i][j] = 1;
                } else if (input.charAt(j) == 'O') {
                    toy[i][j] = 2;
                } else if (input.charAt(j) == 'R') {
                    redCol = i;
                    redRow = j;
                } else if (input.charAt(j) == 'B') {
                    blueCol = i;
                    blueRow = j;
                }
            }
        }

        Queue<Bead> beads = new LinkedList<>();
        beads.add(new Bead(redCol, redRow, blueCol, blueRow, 0));

        // 0: 서, 1: 동, 2: 북, 3: 남
        int[] dCol = {0, 0, -1, 1};
        int[] dRow = {-1, 1, 0, 0};
        int ans = -1;
        while (!beads.isEmpty()) {
            Bead b = beads.poll();
            if (b.cnt >= 10) {
                break;
            }

            for (int idx = 0; idx < 4; idx++) {
                int newRedCol = b.redCol;
                int newRedRow = b.redRow;
                int newBlueCol = b.blueCol;
                int newBlueRow = b.blueRow;

                while (newRedCol + dCol[idx] >= 0 && newRedCol + dCol[idx] <= N - 1 && newRedRow + dRow[idx] >= 0 && newRedRow + dRow[idx] <= M - 1) {
                    if (toy[newRedCol + dCol[idx]][newRedRow + dRow[idx]] == 1 || toy[newRedCol][newRedRow] == 2) {
                        break;
                    }
                    newRedCol += dCol[idx];
                    newRedRow += dRow[idx];
                }

                while (newBlueCol + dCol[idx] >= 0 && newBlueCol + dCol[idx] <= N - 1 && newBlueRow + dRow[idx] >= 0 && newBlueRow + dRow[idx] <= M - 1) {
                    if (toy[newBlueCol + dCol[idx]][newBlueRow + dRow[idx]] == 1 || toy[newBlueCol][newBlueRow] == 2) {
                        break;
                    }
                    newBlueCol += dCol[idx];
                    newBlueRow += dRow[idx];
                }

                if (toy[newBlueCol][newBlueRow] == 2) {
                    continue;
                }

                if (toy[newRedCol][newRedRow] == 2) {
                    ans = b.cnt + 1;
                    break;
                }

                // 이동 후 두 구슬이 겹치는 경우
                if (newRedCol == newBlueCol && newRedRow == newBlueRow) {
                    if (idx == 0) { // 서
                        if (b.redRow < b.blueRow) {
                            newBlueRow++;
                        } else if (b.redRow > b.blueRow) {
                            newRedRow++;
                        }
                    } else if (idx == 1) {  // 동
                        if (b.redRow < b.blueRow) {
                            newRedRow--;
                        } else if (b.redRow > b.blueRow) {
                            newBlueRow--;
                        }
                    } else if (idx == 2) {  // 북
                        if (b.redCol < b.blueCol) {
                            newBlueCol++;
                        } else if (b.redCol > b.blueCol) {
                            newRedCol++;
                        }
                    } else if (idx == 3) {  // 남
                        if (b.redCol < b.blueCol) {
                            newRedCol--;
                        } else if (b.redCol > b.blueCol) {
                            newBlueCol--;
                        }
                    }
                }

                if (visited[newRedCol][newRedRow][newBlueCol][newBlueRow]) {
                    continue;
                }
                visited[newRedCol][newRedRow][newBlueCol][newBlueRow] = true;
                beads.add(new Bead(newRedCol, newRedRow, newBlueCol, newBlueRow, b.cnt + 1));
            }

            if (ans != -1) {
                break;
            }
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.flush();
        bw.close();
    }

}