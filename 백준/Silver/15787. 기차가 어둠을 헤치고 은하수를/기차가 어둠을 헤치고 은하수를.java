import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] trains = new char[N][21];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 20; j++) {
                trains[i][j] = 'X';
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            int x = 0;
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }

            if (order == 1) {
                trains[index - 1][x - 1] = 'O';
            } else if (order == 2) {
                trains[index - 1][x - 1] = 'X';
            } else if (order == 3) {
                for (int j = 19; j > 0; j--) {
                    trains[index - 1][j] = trains[index - 1][j - 1];
                }
                trains[index - 1][0] = 'X';
            } else if (order == 4) {
                for (int j = 0; j < 19; j++) {
                    trains[index - 1][j] = trains[index - 1][j + 1];
                }
                trains[index - 1][19] = 'X';
            }
        }

        Set<String> galaxyTrains = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String str = String.valueOf(trains[i]);
            if (!galaxyTrains.contains(str)) {
                galaxyTrains.add(str);
            }
        }

        bw.write(String.valueOf(galaxyTrains.size()));
        bw.flush();
        bw.close();
    }

}