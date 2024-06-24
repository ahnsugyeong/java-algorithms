import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String result = "";
        int i = 0;
        while (i < str.length()) {
            // <tag>
            if (str.charAt(i) == '<') {
                while (str.charAt(i) != '>') {
                    result += str.charAt(i);
                    i++;
                }
                result += str.charAt(i);
                i++;
            }

            // blank
            if (i < str.length() && str.charAt(i) == ' ') {
                result += str.charAt(i);
                i++;
            }

            // string
            Stack<Character> stack = new Stack<>();
            while (i < str.length() && ((str.charAt(i) >= '0' && str.charAt(i) <= '9') || (str.charAt(i) >= 'a'
                    && str.charAt(i) <= 'z'))) {
                stack.add(str.charAt(i));
                i++;
            }
            
            while (!stack.isEmpty()) {
                char c = stack.peek();
                stack.pop();
                result += c;
            }
        }

        bw.write(result);
        bw.flush();
        bw.close();
    }
}
