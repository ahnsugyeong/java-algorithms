import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= 'a' && str[i] <= 'z') {
                str[i] = (char) ('A' + str[i] - 'a');
            } else {
                str[i] = (char) ('a' + str[i] - 'A');
            }
        }
        System.out.println(String.valueOf(str));
    }

}