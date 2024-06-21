import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            
            if (order.equals("push")) {
                int X = Integer.parseInt(st.nextToken());
                s.push(X);
            } else if (order.equals("pop")) {
                if (s.isEmpty()) {
                    bw.write("-1");
                    bw.newLine();
                } else {
                    bw.write(String.valueOf(s.peek()));
                    bw.newLine();
                    s.pop();
                }
            } else if (order.equals("size")) {
                bw.write(String.valueOf(s.size()));
                bw.newLine();
            } else if (order.equals("empty")) {
                if (s.isEmpty()) {
                    bw.write("1");    
                } else {
                    bw.write("0");
                }
                bw.newLine();
            } else if (order.equals("top")) {
                if (s.isEmpty()) {
                    bw.write("-1");
                } else {
                    bw.write(String.valueOf(s.peek()));
                }
                bw.newLine();
            }
            
        }
        
        bw.flush();
        bw.close();
    }
    
}
