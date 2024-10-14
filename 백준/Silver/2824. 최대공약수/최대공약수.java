import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger A = new BigInteger("1");
        BigInteger B = new BigInteger("1");

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A = A.multiply(new BigInteger(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B = B.multiply(new BigInteger(st.nextToken()));
        }

        String tmp = A.gcd(B).toString();
        if (tmp.length() > 9) {
            System.out.println(tmp.substring(tmp.length() - 9));
        } else {
            System.out.println(tmp);
        }
    }

}
