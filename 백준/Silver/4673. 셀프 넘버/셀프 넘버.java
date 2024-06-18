import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        boolean[] check = new boolean[10001];
        
        for (int i = 1; i < 10001; i++) {
            int n = d(i);
            if(n > 10000) {
                continue;
            }
            check[n] = true;
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for(int i = 1; i < 10001; i++) {
            if (check[i]) {
                continue;
            }
            bw.write(String.valueOf(i));
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
    }
    
    public static int d(int num) {
        int sum = num;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    
}