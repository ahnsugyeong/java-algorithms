import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] electronics = new int[K];
        for (int i = 0; i < K; i++) {
            electronics[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int plugCnt = 0;
        List<Integer> plugs = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            // 이미 꽂혀있는 경우, 아무것도 하지 않는다.
            if (plugs.contains(electronics[i])) {
                continue;
            }

            // 플러그 꽂을 자리가 있는 경우
            if (plugs.size() < N) {
                plugs.add(electronics[i]);
                continue;
            }

            // 플러그 꽂을 자리가 없는 경우
            // -> 이후에 사용될 일이 없거나, 최대한 늦게 사용되는 플러그 탐색
            int removablePlug = findRemovablePlug(plugs, electronics, K, i);
            plugs.remove(Integer.valueOf(removablePlug));
            cnt++;
            plugs.add(electronics[i]);
        }
        System.out.println(cnt);
    }

    public static int findRemovablePlug(List<Integer> plugs, int[] electronics, int K, int index) {
        int[] future = new int[K + 1];
        for (int curPlug : plugs) {
            boolean found = false;
            for (int i = index + 1; i < K; i++) {
                if (curPlug == electronics[i]) {
                    found = true;
                    if (future[electronics[i]] == 0) {
                        future[electronics[i]] = i;
                    }
                }
            }
            if (!found) {
                return curPlug;
            }
        }
        int maxIndex = Integer.MIN_VALUE;
        for (int i = 0; i < K + 1; i++) {
            maxIndex = Math.max(maxIndex, future[i]);
        }
        return electronics[maxIndex];

    }

}
/*

1 10
1 1 2 1 1 1 3 1 1 1

3 100
56 71 70 25 52 77 76 8 68 71 51 65 13 23 7 16 19 54 95 18 86 74 29 76 61 93 44 96 32 72 64 19 50 49 22 14 7 64 24 83 6 3 2 76 99 7 76 100 60 60 6 50 90 49 27 51 37 61 16 84 89 51 73 28 90 77 73 39 78 96 78 13 92 54 70 69 62 78 7 75 30 67 97 98 19 86 90 90 2 39 41 58 57 84 19 8 52 39 26 7

3 14
1 4 3 2 5 4 3 2 5 3 4 2 3 4
 */