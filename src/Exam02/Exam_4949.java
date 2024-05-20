package Exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str == null || str.equals(".")) break;

            boolean isBalanced = isBalanced(str);
            if (isBalanced) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static boolean isBalanced(String str) {
        int countParentheses = 0;
        int countBrackets = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                countParentheses++;
            } else if (ch == ')') {
                countParentheses--;
            } else if (ch == '[') {
                countBrackets++;
            } else if (ch == ']') {
                countBrackets--;
            }

            if (countParentheses < 0 || countBrackets < 0) {
                return false; // 여는 괄호보다 닫는 괄호가 더 많은 경우
            }
        }

        return countParentheses == 0 && countBrackets == 0;
    }
}
