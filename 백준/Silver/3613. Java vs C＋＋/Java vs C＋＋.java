import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        boolean isCpp = true;
        boolean isJava = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '_') {
                // '_' 연속되면 에러
                if (i < str.length() - 1 && str.charAt(i + 1) == '_') {
                    isCpp = false;
                }
                isJava = false;
            }
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                isCpp = false;
            }
        }
        // 맨 앞이나 뒤 문자가 '_'이면 에러
        if (str.charAt(0) == '_' || str.charAt(str.length() - 1) == '_') {
            isCpp = false;
        }

        // 맨 앞 문자가 대문자면 에러
        if (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z') {
            isJava = false;
        }


        if (!isCpp && !isJava) {
            bw.write("Error!");
        } else if (isCpp) {
            String ans = convertCppToJava(str);
            bw.write(ans);
        } else if (isJava) {
            String ans = convertJavaToCpp(str);
            bw.write(ans);
        }
        bw.flush();
        bw.close();
    }

    static String convertCppToJava(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '_') {
                sb.append((char) ('A' + str.charAt(i + 1) - 'a'));
                i++;
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    static String convertJavaToCpp(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                sb.append('_');
                sb.append((char) ('a' + str.charAt(i) - 'A'));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

}