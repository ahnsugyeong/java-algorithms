import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            
            for (int i = 0; i < K - 1; i++) {
                if (q.isEmpty()) {
                    break;
                }
                q.add(q.poll());
            }
            int num = q.poll();
            ans.add(num);
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("<");
        for(int i = 0; i < ans.size(); i++) {
            bw.write(String.valueOf(ans.get(i)));
            if (i != ans.size() - 1) {
                bw.write(", ");
            }
        }
        bw.write(">");
        
        bw.flush();
        bw.close();
    }
    
}