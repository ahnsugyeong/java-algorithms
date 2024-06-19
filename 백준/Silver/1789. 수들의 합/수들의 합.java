import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long S = Long.parseLong(br.readLine());
        
        long sum = 0;
        long num = 0;
        while (S >= sum) {
            num++;
            sum += num;
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(num - 1));
        
        bw.flush();
        bw.close();
    }
    
}