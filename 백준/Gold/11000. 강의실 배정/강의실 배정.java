import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(start, end));
        }

        // 시작 시간, 종료 시간 순으로 오름차순 정렬
        Collections.sort(lectures);

        Queue<Integer> q = new PriorityQueue<>();
        for (Lecture lecture : lectures) {
            // 만약 꺼낸 종료시간이 시작시간보다 크면 새로운 강의실을 사용,
            // 꺼낸 종료시간이 시작시간보다 작으면 poll()한 뒤 room에 새로운 강의의 종료시간을 넣으면 됨
            if (!q.isEmpty() && q.peek() <= lecture.start) {
                q.poll();
            }
            q.add(lecture.end);
        }

        System.out.println(q.size());
    }

    public static class Lecture implements Comparable<Lecture> {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture l) {
            if (this.start == l.start) {
                return Integer.compare(this.end, l.end);
            }
            return Integer.compare(this.start, l.start);
        }
    }
}