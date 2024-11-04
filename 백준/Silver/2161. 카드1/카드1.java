import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            System.out.print(queue.poll() + " ");
            int ele = queue.poll();
            queue.add(ele);
        }
        System.out.println(queue.poll());
    }
}
