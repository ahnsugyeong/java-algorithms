import java.util.*;
import java.io.*;

public class Main {

    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String control = br.readLine();
            int dir = 0;    // 북, 동, 남, 서
            int minRow = 0;
            int maxRow = 0;
            int minCol = 0;
            int maxCol = 0;
            int curRow = 0;
            int curCol = 0;
            for(int j = 0; j < control.length(); j++) {
                char order = control.charAt(j);
                if (order == 'F') {
                    curRow += dRow[dir];
                    curCol += dCol[dir];
                    minRow = Math.min(minRow, curRow);
                    maxRow = Math.max(maxRow, curRow);
                    minCol = Math.min(minCol, curCol);
                    maxCol = Math.max(maxCol, curCol);
                } else if  (order == 'B') {
                    curRow -= dRow[dir];
                    curCol -= dCol[dir];
                    minRow = Math.min(minRow, curRow);
                    maxRow = Math.max(maxRow, curRow);
                    minCol = Math.min(minCol, curCol);
                    maxCol = Math.max(maxCol, curCol);
                } else if (order == 'L') {
                    if (dir == 0) {
                        dir = 3;
                    } else {
                        dir--;
                    }
                } else if (order == 'R') {
                    dir = (dir + 1) % 4;
                }
            }

            int totalRow = maxRow - minRow;
            int totalCol = maxCol - minCol;
            bw.write(String.valueOf(totalRow * totalCol));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

}