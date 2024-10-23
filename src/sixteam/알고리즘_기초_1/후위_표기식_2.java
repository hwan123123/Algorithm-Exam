package sixteam.알고리즘_기초_1;

import java.util.Scanner;
import java.util.Stack;

public class 후위_표기식_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        String expression = sc.nextLine();

        double[] values = new double[N]; // 피연산자 값 입력
        for (int i = 0; i < N; i++) {
            values[i] = sc.nextDouble();
        }

        Stack<Double> stack = new Stack<>();

        // 후위 표기식 계산
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch >= 'A' && ch <= 'Z') { // 피연산자인 경우
                stack.push(values[ch - 'A']);
            } else { // 연산자인 경우
                double b = stack.pop();
                double a = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }

        double result = stack.pop();
        System.out.printf("%.2f\n", result);
    }
}
