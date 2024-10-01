import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Character> operator;
    static List<Integer> operand;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        operator = new ArrayList<>();
        operand = new ArrayList<>();
        ans = Integer.MIN_VALUE;

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                operand.add(input.charAt(i) - '0');
            } else {
                operator.add(input.charAt(i));
            }
        }

        DFS(operand.get(0), 0);

        System.out.println(ans);
    }

    public static void DFS(int result, int operatorIdx) {
        // 인덱스가 범위를 초과하는 경우
        if (operatorIdx > operator.size() - 1) {
            ans = Math.max(ans, result);
            return;
        }

        // 오른쪽 피연산자에 괄호가 없는 경우
        int tmp1 = calculate(operator.get(operatorIdx), result, operand.get(operatorIdx + 1));
        DFS(tmp1, operatorIdx + 1);

        // 오른쪽 피연산자에 괄호가 있는 경우
        // 1. 다음 피연산자에 괄호를 칠 수 없으면 return
        if (operatorIdx >= operator.size() - 1) {
            return;
        }
        // 2. 오른쪽 괄호 안 계산
        int tmp2 = calculate(operator.get(operatorIdx + 1), operand.get(operatorIdx + 1), operand.get(operatorIdx + 2));
        // 3. 왼쪽 피연산자와 오른쪽 결과 계산
        DFS(calculate(operator.get(operatorIdx), result, tmp2), operatorIdx + 2);
    }

    public static int calculate(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+': return operand1 + operand2;
            case '-': return operand1 - operand2;
            case '*': return operand1 * operand2;
            default: return -1;
        }
    }

}
