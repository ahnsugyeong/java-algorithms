import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       
       List<Dot> dots = new ArrayList<>();
       for (int i = 0; i < N; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           int x = Integer.parseInt(st.nextToken());
           int y = Integer.parseInt(st.nextToken());
           dots.add(new Dot(x, y));
       }
       
       dots.sort(new DotComparator());
       
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
       for (Dot dot : dots) {
           bw.write(dot.x + " " + dot.y);
           bw.newLine();
       }
       
       bw.flush();
       bw.close();
    }
    
    static class Dot {
        public int x;
        public int y;
        
        Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static class DotComparator implements Comparator<Dot> {
        
        @Override
        public int compare(Dot dot1, Dot dot2) {
            if (dot1.x != dot2.x) {
                return Integer.compare(dot1.x, dot2.x);
            } else {
                return Integer.compare(dot1.y, dot2.y);
            }
        }
    }
}
