import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        
        int stick = 64;
        int cnt = 0;
        while (X > 0) {
            if (stick > X) {
                stick /= 2;
            } else {
                X -= stick;
                cnt++;
            }
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
    
}