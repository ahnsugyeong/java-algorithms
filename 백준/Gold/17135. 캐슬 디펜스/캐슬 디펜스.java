import java.io.*;
import java.util.*;

public class Main {

    static int ans;
    static int N, M, D;
    static boolean[] check;
    static List<Position> enemies;
    static List<Integer> archers;   // 궁수 열 값 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        ans = 0;

        check = new boolean[M];
        enemies = new ArrayList<>();
        archers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int ele = Integer.parseInt(st.nextToken());
                if (ele == 1) {
                    enemies.add(new Position(i, j));
                }
            }
        }

        DFS(0, 0);

        System.out.println(ans);
    }

    // 궁수 위치 선정
    static void DFS(int index, int depth) {
        if (depth == 3) {
            archers.clear();
            for (int i = 0; i < M; i++) {
                if (check[i]) {
                    archers.add(i);
                }
            }
            // 공격으로 제거할 수 있는 적
            ans = Math.max(ans, attack());
            return;
        }

        for (int i = index; i < M; i++) {
            check[i] = true;
            DFS(i + 1, depth + 1);
            check[i] = false;
        }
    }

    // 궁수 공격 시뮬레이션
    static int attack() {
        int cnt = 0;
        List<Position> tmpEnemies = new ArrayList<>();
        for (Position enemy : enemies) {
            tmpEnemies.add(new Position(enemy.col, enemy.row));  // 개별 Position 객체 복사
        }

        // 적들이 한 칸씩 내려옴
        for (int turn = 0; turn < N; turn++) {
            // 각 궁수가 공격할 적 선택
            List<Position> targets = new ArrayList<>();
            for (int archerRow : archers) {
                Position target = null;
                int minDistance = Integer.MAX_VALUE;

                for (Position enemy : tmpEnemies) {
                    int distance = getDistance(new Position(N, archerRow), enemy);

                    // 사정거리 밖이면 고려 X
                    if (distance > D) {
                        continue;
                    }

                    if (minDistance > distance) {
                        minDistance = distance;
                        target = enemy;
                    } else if (minDistance == distance && target.row > enemy.row) {
                        target = enemy;
                    }
                }

                if (target != null && !targets.contains(target)) {
                    targets.add(target);
                }
            }

            // 동시에 공격
            for (Position target : targets) {
                tmpEnemies.remove(target);
                cnt++;
            }

            // 적 한 칸씩 아래로 이동
            Iterator<Position> it = tmpEnemies.iterator();
            while (it.hasNext()) {
                Position enemy = it.next();
                enemy.col++;
                if (enemy.col >= N) {
                    it.remove();  // 적이 성에 도착하면 제거
                }
            }
        }
        return cnt;
    }

    static int getDistance(Position pos1, Position pos2) {
        return Math.abs(pos1.col - pos2.col) + Math.abs(pos1.row - pos2.row);
    }

    static class Position {
        int col;
        int row;

        public Position(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }
}