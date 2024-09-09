import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            int startDate = startMonth * 100 + startDay;
            int endDate = endMonth * 100 + endDay;
            flowers[i] = new Flower(startDate, endDate);
        }

        Arrays.parallelSort(flowers);

        int startDate = 301;
        int endDate = 1201;
        int index = 0;
        int maxDate = 0;
        int cnt = 0;
        while (startDate < endDate) {
            boolean isFound = false;

            for (int i = index; i < N; i++) {
                if (startDate < flowers[i].startDate) { // 기준일보다 늦게 시작하면 추가 X
                    break;
                }

                if (maxDate < flowers[i].endDate) { // 종료일이 가장 늦은 꽃 추가
                    maxDate = flowers[i].endDate;
                    index = i + 1;
                    isFound = true;
                }
            }

            if (isFound) {  // 추가할 꽃이 존재하는 경우
                startDate = maxDate;    // 최대 종료일을 다음 기준일로 설정
                cnt++;
            } else {
                break;
            }
        }

        if (maxDate < endDate) {    // 마지막으로 추가한 꽃의 종료일이 12/01 이전인 경우
            System.out.println(0);
        } else {
            System.out.println(cnt);
        }

    }

    public static class Flower implements Comparable<Flower> {
        int startDate;
        int endDate;

        public Flower(int startDate, int endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        @Override
        public int compareTo(Flower f) {
            // 1. 시작일 빠른 꽃 우선
            // 2. 시작일이 같다면, 종료일 늦은 꽃 우선
            if (this.startDate == f.startDate) {
                return Integer.compare(f.endDate, this.endDate);
            }
            return Integer.compare(this.startDate, f.startDate);
        }
    }

}
