package Exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();

            boolean isBalanced = isBalanced(str);
            if (isBalanced) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean isBalanced(String str) {
        int countParentheses = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                countParentheses++;
            } else if (ch == ')') {
                countParentheses--;
            }

            if (countParentheses < 0) {
                return false; // 여는 괄호보다 닫는 괄호가 더 많은 경우
            }
        }

        return countParentheses == 0;
    }
}
