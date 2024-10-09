import java.io.*;
import java.util.*;

public class Main {

    static int[][] trucks;
    static int n, w, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        trucks = new int[n][2]; // 0: 도로에서 트럭 위치, 1: 트럭의 무게
        for (int i = 0; i < n; i++) {
            trucks[i][1] = Integer.parseInt(st.nextToken());
        }

        int i = 0, time = 1;
        while (true) {
            // 도로 위의 트럭 이동
            moveTrucks();
            
            int sum = getSum();
            if (i == n) {
                if (sum == 0) {
                    break;
                }
                time++;
                continue;
            }

            if (sum + trucks[i][1] <= L) {
                // 새로운 트럭 추가
                trucks[i][0] = 1;
                i++;
            }
            
            time++;
        }
        System.out.println(time);

    }

    static int getSum() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (trucks[i][0] >= 1 && trucks[i][0] <= w) {
                sum += trucks[i][1];
            }
        }
        return sum;
    }

    static void moveTrucks() {
        for (int i = 0; i < n; i++) {
            if (trucks[i][0] == 0 || trucks[i][0] == w + 1) {
                continue;
            }
            trucks[i][0]++;
        }
    }


}