import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            boxes.add(new Box(start, end, cnt));
        }
        // end(오름차순) -> start(오름차순) 정렬
        Collections.sort(boxes);

        // 트럭의 최대 용량으로 초기화
        int[] towns = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            towns[i] = C;
        }

        int ans = 0;
        for (Box curBox: boxes) {
            // 구간 사이의 최소 택배 개수 계산
            int minCnt = Integer.MAX_VALUE;
            for (int i = curBox.start; i < curBox.end; i++) {
                minCnt = Math.min(minCnt, towns[i]);
            }

            // 배달 가능한 수만큼 마을에서 빼고, 배달 완료 cnt 증가 
            int boxCnt = Math.min(minCnt, curBox.cnt);
            for (int i = curBox.start; i < curBox.end; i++) {
                towns[i] -= boxCnt;
            }
            ans += boxCnt;
        }

        System.out.println(ans);
    }

    static class Box implements Comparable<Box> {
        int start;
        int end;
        int cnt;

        public Box(int start, int end, int cnt) {
            this.start = start;
            this.end = end;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Box box) {
            if (this.end == box.end) {
                return Integer.compare(this.start, box.start);
            }
            return Integer.compare(this.end, box.end);
        }
    }

}