import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // :: 확인 후 분리
        String[] parts = input.split("::");

        // 왼쪽 오른쪽 각각 처리
        String[] left = parts[0].isEmpty() ? new String[0] : parts[0].split(":");
        String[] right = parts.length > 1 && !parts[1].isEmpty() ? parts[1].split(":") : new String[0];

        int totalGroupCnt = 8;
        int missingGroupCnt = totalGroupCnt - (left.length + right.length);

        // 최종 주소
        String[] result = new String[totalGroupCnt];
        int index = 0;

        // 왼쪽 채우기
        for (String group : left) {
            result[index++] = fillZeros(group);
        }

        // 가운데 0으로 채울 그룹 채우기
        for (int i = 0; i < missingGroupCnt; i++) {
            result[index++] = "0000";
        }

        // 오른쪽 채우기
        for (String group : right) {
            result[index++] = fillZeros(group);
        }

        System.out.println(String.join(":", result));
    }

    static String fillZeros(String group) {
        StringBuilder sb = new StringBuilder();
        int zeroCnt = 4 - group.length();
        sb.append("0".repeat(zeroCnt));
        sb.append(group);
        return sb.toString();
    }

}
