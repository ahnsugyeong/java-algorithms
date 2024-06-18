import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       
       List<Integer> numbers = new ArrayList<>();
       for(int i = 0; i < N; i++) {
           numbers.add(Integer.parseInt(br.readLine()));
       }
       
       Collections.sort(numbers);
       
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       for(int number: numbers) {
           bw.write(String.valueOf(number));
           bw.newLine();
       }
       
       bw.flush();
       bw.close();
    }
    
}