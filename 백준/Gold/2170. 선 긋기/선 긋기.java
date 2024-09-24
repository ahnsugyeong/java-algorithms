import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lines.add(new Line(start, end));
        }

        Collections.sort(lines);


        int start = lines.get(0).start;
        int end = lines.get(0).end;
        long len = end - start;
        for (int i = 1; i < N; i++) {
            Line line = lines.get(i);
            if (line.start >= start && line.end <= end) { // 현재 선이 이전 선에 포함되는 경우
                continue;
            } else if (line.start <= end) {  // 현재 선과 이전 선의 일부가 겹치는 경우
                len += line.end - end;
            } else {  // 현재 선과 이전 선이 겹치지 않는 경우
                len += line.end - line.start;
            }
            start = line.start;
            end = line.end;
        }

        System.out.println(len);
    }

    public static class Line implements Comparable<Line> {
        int start;
        int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Line line) {
            if (this.start == line.start) {
                return Integer.compare(this.end, line.end);
            }
            return Integer.compare(this.start, line.start);
        }
    }

}