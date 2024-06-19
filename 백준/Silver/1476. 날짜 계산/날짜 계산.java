import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int year = 1;
        int e = 0, s = 0, m = 0;
        while(true) {
            e++;
            s++;
            m++;
            
            if (e == 16) {
                e = 1;
            }
            if (s == 29) {
                s = 1;
            }
            if (m == 20) {
                m = 1;
            }
            
            if (e == E && s == S && m == M) {
                break;
            }
            year++;
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(year));
        bw.flush();
        bw.close();
    }
    
}