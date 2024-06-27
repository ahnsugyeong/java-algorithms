import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        Vector<FruitInfo> fruits = new Vector<>();
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            fruits.add(new FruitInfo(dir, len));
        }

        int maxWidth = Integer.MIN_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        int maxWidthIdx = 0;
        int maxHeightIdx = 0;
        for (int i = 0; i < 6; i++) {
            FruitInfo cur = fruits.get(i);
            if (cur.dir == 1 || cur.dir == 2) {
                if (maxWidth < cur.len) {
                    maxWidth = cur.len;
                    maxWidthIdx = i;
                }
            } else if (cur.dir == 3 || cur.dir == 4) {
                if (maxHeight < cur.len) {
                    maxHeight = cur.len;
                    maxHeightIdx = i;
                }
            }
        }

        int leftWidthIdx = maxWidthIdx - 1;
        int rightWidthIdx = maxWidthIdx + 1;
        if (leftWidthIdx == -1) {
            leftWidthIdx = 5;
        }
        if (rightWidthIdx == 6) {
            rightWidthIdx = 0;
        }

        int leftHeightIdx = maxHeightIdx - 1;
        int rightHeightIdx = maxHeightIdx + 1;
        if (leftHeightIdx == -1) {
            leftHeightIdx = 5;
        }
        if (rightHeightIdx == 6) {
            rightHeightIdx = 0;
        }

        int emptyWidth = Math.abs(fruits.get(leftWidthIdx).len - fruits.get(rightWidthIdx).len);
        int emptyHeight = Math.abs(fruits.get(leftHeightIdx).len - fruits.get(rightHeightIdx).len);
        int total = maxWidth * maxHeight - emptyWidth * emptyHeight;
        bw.write(String.valueOf(total * K));

        bw.flush();
        bw.close();
    }

    static class FruitInfo {
        int dir;
        int len;

        FruitInfo(int dir, int len) {
            this.dir = dir;
            this.len = len;
        }

    }

}