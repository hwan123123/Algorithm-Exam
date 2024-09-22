package sixteam;

import java.util.Scanner;
import java.util.Stack;

public class Exam_1918 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infix = sc.nextLine(); // 중위 표기식 입력
        StringBuilder postfix = new StringBuilder(); // 후위 표기식 결과 저장용
        Stack<Character> stack = new Stack<>(); // 연산자 저장용

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // 피연산자인 경우
            if (Character.isLetter(ch)) {
                postfix.append(ch); // 바로 후위 표기식에 추가
            }
            // 열린 괄호는 스택에 추가 (우선순위 확인을 위해)
            else if (ch == '(') {
                stack.push(ch);
            }
            // 닫힌 괄호가 나오는 경우
            else if (ch == ')') {
                // 열린 괄호를 만날 때까지 스택에 있는 연산자를 후위 표기식에 추가
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()); // 스택에 있는 연산자를 꺼낸 후 추가
                }
                stack.pop(); // 열린 괄호 제거
            }
            // 연산자인 경우
            else {
                // 스택에 있는 연산자가 현재 연산자보다 우선 순위가 높은 경우 스택에서 꺼내고 후위 표기식에 추가
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(ch)) {
                    postfix.append(stack.pop());
                }
                stack.push(ch); // 현재 연산자 스택에 추가
            }
        }

        // 스택에 남아있는 연산자 모두 후위 표기식에 추가
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        System.out.println(postfix);
    }

    // 연산자 우선순위 확인용 메서드
    public static int priority(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        } else {
            return 0;
        }
    }
}
