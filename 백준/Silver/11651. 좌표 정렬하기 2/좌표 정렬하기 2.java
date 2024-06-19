import java.util.*;
import java.io.*;

class Main {
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
        
        for (int i = 0; i < dots.size(); i++) {
            Dot dot = dots.get(i);
            bw.write(dot.x + " " + dot.y);
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
    }
    
    static class Dot {
        public int x;
        public int y;
        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static class DotComparator implements Comparator<Dot> {
        
        @Override
        public int compare(Dot d1, Dot d2) {
            if (d1.y == d2.y) {
                return Integer.compare(d1.x, d2.x);
            }
            return Integer.compare(d1.y, d2.y);
        }
    }
    
}