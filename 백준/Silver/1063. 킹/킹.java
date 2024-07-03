import java.util.*;
import java.io.*;

public class Main {

    static char[] king;
    static char[] stone;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        king = st.nextToken().toCharArray();
        stone = st.nextToken().toCharArray();
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String order = br.readLine();
            move(order);
        }

        bw.write(String.valueOf(king));
        bw.newLine();
        bw.write(String.valueOf(stone));

        bw.flush();
        bw.close();
    }

    public static void move(String order) {
        if (order.equals("R")) {
            if (king[0] + 1 <= 'H') {
                king[0]++;
                if (String.valueOf(king).equals(String.valueOf(stone))) {
                    if (stone[0] + 1 <= 'H') {
                        stone[0]++;
                    } else {
                        king[0]--;
                    }
                }
            }
        } else if (order.equals("L")) {
            if (king[0] - 1 >= 'A') {
                king[0]--;
                if (String.valueOf(king).equals(String.valueOf(stone))) {
                    if (stone[0] - 1 >= 'A') {
                        stone[0]--;
                    } else {
                        king[0]++;
                    }
                }
            }
        } else if (order.equals("B")) {
            if (king[1] - 1 >= '1') {
                king[1]--;
                if (String.valueOf(king).equals(String.valueOf(stone))) {
                    if (stone[1] - 1 >= '1') {
                        stone[1]--;
                    } else {
                        king[1]++;
                    }
                }
            }
        } else if (order.equals("T")) {
            if (king[1] + 1 <= '8') {
                king[1]++;
                if (String.valueOf(king).equals(String.valueOf(stone))) {
                    if (stone[1] + 1 <= '8') {
                        stone[1]++;
                    } else {
                        king[1]--;
                    }
                }
            }
        } else if (order.equals("RT")) {
            if (king[0] + 1 <= 'H' && king[1] + 1 <= '8') {
                king[0]++;
                king[1]++;
                if (String.valueOf(king).equals(String.valueOf(stone))) {
                    if (stone[0] + 1 <= 'H' && stone[1] + 1 <= '8') {
                        stone[0]++;
                        stone[1]++;
                    } else {
                        king[0]--;
                        king[1]--;
                    }
                }
            }
        } else if (order.equals("LT")) {
            if (king[0] - 1 >= 'A' && king[1] + 1 <= '8') {
                king[0]--;
                king[1]++;
                if (String.valueOf(king).equals(String.valueOf(stone))) {
                    if (stone[0] - 1 >= 'A' && stone[1] + 1 <= '8') {
                        stone[0]--;
                        stone[1]++;
                    } else {
                        king[0]++;
                        king[1]--;
                    }
                }
            }
        } else if (order.equals("RB")) {
            if (king[0] + 1 <= 'H' && king[1] - 1 >= '1') {
                king[0]++;
                king[1]--;
                if (String.valueOf(king).equals(String.valueOf(stone))) {
                    if (stone[0] + 1 <= 'H' && stone[1] - 1 >= '1') {
                        stone[0]++;
                        stone[1]--;
                    } else {
                        king[0]--;
                        king[1]++;
                    }
                }
            }
        } else if (order.equals("LB")) {
            if (king[0] - 1 >= 'A' && king[1] - 1 >= '1') {
                king[0]--;
                king[1]--;
                if (String.valueOf(king).equals(String.valueOf(stone))) {
                    if (stone[0] - 1 >= 'A' && stone[1] - 1 >= '1') {
                        stone[0]--;
                        stone[1]--;
                    } else {
                        king[0]++;
                        king[1]++;
                    }
                }
            }
        }
    }
}