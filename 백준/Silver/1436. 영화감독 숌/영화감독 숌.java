import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
    
        int num = 1;
        int i = 0;
        while (i < N) {
            num++;
            if (String.valueOf(num).contains("666")) {
                i++;
            }
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(num));
        bw.flush();
        bw.close();
    }
    
}