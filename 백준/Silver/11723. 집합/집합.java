import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int M = Integer.parseInt(br.readLine());
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int x = 0;
            if (!order.equals("all") && !order.equals("empty")) {
                x = Integer.parseInt(st.nextToken());   
            }
            
            if (order.equals("add")) {
                s.add(x);
            } else if (order.equals("remove")) {
                s.remove(x);
            } else if (order.equals("check")) {
                if (s.contains(x)) {
                    bw.write("1");
                } else {
                    bw.write("0");
                }
                bw.newLine();
            } else if (order.equals("toggle")) {
                if (s.contains(x)) {
                    s.remove(x);
                } else {
                    s.add(x);
                }
            } else if (order.equals("all")) {
                s.clear();
                for(int j = 1; j <= 20; j++) {
                    s.add(j);
                }
            } else if (order.equals("empty")) {
                s.clear();
            }
        }
        
        bw.flush();
        bw.close();
    }
    
}