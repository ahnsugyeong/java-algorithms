import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Assignment> assignments = new Stack<>();
        int ans = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("1")) {
                int A = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                assignments.add(new Assignment(A, T));
            }

            if (!assignments.isEmpty()) {
                assignments.peek().T--;
                if (assignments.peek().T == 0) {
                    ans += assignments.peek().A;
                    assignments.pop();
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    static class Assignment {
        int A;
        int T;

        Assignment(int A, int T) {
            this.A = A;
            this.T = T;
        }

    }
}