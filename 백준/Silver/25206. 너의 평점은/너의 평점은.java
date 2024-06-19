import java.util.*;
import java.io.*;

class Main {
    
    public static int numbers[] = new int[9]; // 0 1 2 3 4 5 6(9) 7 8
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        double cnt = 0.0;
        double sum = 0.0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String subject = st.nextToken();
            double num = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            
            if (grade.equals("A+")) {
                sum += num * 4.5;
                cnt += num;
            } else if (grade.equals("A0")) {
                sum += num * 4.0;
                cnt += num;
            } else if (grade.equals("B+")) {
                sum += num * 3.5;
                cnt += num;
            } else if (grade.equals("B0")) {
                sum += num * 3.0;
                cnt += num;
            } else if (grade.equals("C+")) {
                sum += num * 2.5;
                cnt += num;
            } else if (grade.equals("C0")) {
                sum += num * 2.0;
                cnt += num;
            } else if (grade.equals("D+")) {
                sum += num * 1.5;
                cnt += num;
            } else if (grade.equals("D0")) {
                sum += num * 1.0;
                cnt += num;
            } else if (grade.equals("F")) {
                sum += num * 0.0;
                cnt += num;
            }
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sum / cnt));
        
        bw.flush();
        bw.close();
    }
    
}