import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int cnt = -1;
        for (int i = N / 5; i >= 0; i--) {
            int remainder = N - (i * 5);
            if (remainder % 3 == 0) {
                cnt = i + (remainder / 3);
                break;
            }
        }
      
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
    
}
