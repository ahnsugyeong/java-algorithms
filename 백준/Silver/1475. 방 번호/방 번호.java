import java.util.*;
import java.io.*;

class Main {
    
    public static int numbers[] = new int[9]; // 0 1 2 3 4 5 6(9) 7 8
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            int num = Character.getNumericValue(input.charAt(i));
            if (num == 9) {
                num = 6;
            }
            numbers[num]++;
        }
        if (numbers[6] % 2 == 1) {
            numbers[6]++;
        }
        numbers[6] /= 2;
        
        int maxVal = 0;
        for (int i = 0; i < 9; i++) {
            maxVal = Math.max(maxVal, numbers[i]);
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(maxVal));
        bw.flush();
        bw.close();
    }
    
}