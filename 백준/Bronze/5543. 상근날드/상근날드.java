import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] burgers = new int[3];
        for (int i = 0; i < 3; i++) {
            burgers[i] = Integer.parseInt(br.readLine());
        }

        int[] beverages = new int[2];
        for (int i = 0; i < 2; i++) {
            beverages[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(burgers);
        Arrays.sort(beverages);

        System.out.println(burgers[0] + beverages[0] - 50);
    }

}