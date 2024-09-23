package sixteam;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        int count = 0; // 총 조각 개수 초기화

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') { // 여는 괄호인 경우
                stack.push(c); // 스택에 추가하여 쇠막대기 시작 확인
            } else { // 닫는 괄호인 경우
                stack.pop(); // 쇠막대기 제거

                if (input.charAt(i - 1) == '(') { // 바로 직전 문자가 여는 괄호면 레이저
                    count += stack.size(); // 레이저가 쇠막대기를 자름 -> 스택 크기만큼 조각 추가
                } else { // 쇠막대기의 끝인 경우
                    count++; // 끝난 쇠막대기는 한 조각을 추가
                }
            }
        }
        // () (((()())(())())) (())
        // 3 + 3 + 1 + 3 + 1 + 2 + 2 + 2
        System.out.println(count);
    }
}
