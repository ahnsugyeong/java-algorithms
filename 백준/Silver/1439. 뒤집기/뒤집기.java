import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int zeroCnt = 0, oneCnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if (i == input.length() - 1) {
                if (input.charAt(i) == '0') {
                    zeroCnt++;
                } else if (input.charAt(i) == '1') {
                    oneCnt++;
                }
                break;
            }
            
            if (input.charAt(i) == '0' && input.charAt(i + 1) == '1') {
                zeroCnt++;
            }
            if (input.charAt(i) == '1' && input.charAt(i + 1) == '0') {
                oneCnt++;
            }
        }

        System.out.println(Math.min(zeroCnt, oneCnt));
    }
}