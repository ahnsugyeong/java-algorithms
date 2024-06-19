import java.util.*;
import java.io.*;

class Main {
    
    private static boolean[][] paper = new boolean[101][101];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    paper[x + j][y + k] = true;
                }
            }
        }
    
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (paper[i][j]) {
                    sum++;
                }
            }
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sum));
        
        bw.flush();
        bw.close();
    }
    
}