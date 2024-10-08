import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(a);

        int left = 0, right = n - 1, cnt = 0;
        while (left < right) {
            if (a[left] + a[right] == x) {
                cnt++;
                left++;
                right--;
            } else if (a[left] + a[right] < x) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(cnt);

    }

}