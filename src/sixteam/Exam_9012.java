package sixteam;

import java.util.Scanner;
import java.util.Stack;

public class Exam_9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스의 개수 입력
        sc.nextLine(); // 개행 처리

        for (int i = 0; i < T; i++) {
            String ps = sc.nextLine(); // 괄호 문자열 입력

            if (isVPS(ps)) { // VPS 여부 확인
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    // 괄호 문자열이 VPS인지 확인하는 메서드
//    private static boolean isVPS(String ps) {
//        Stack<Character> stack = new Stack<>();
//
//        for (char c : ps.toCharArray()) {
//            if (c == '(') { // 여는 괄호인 경우
//                stack.push(c); // 스택에 추가
//            } else if (c == ')') { // 닫는 괄호인 경우
//                if (stack.isEmpty()) { // 스택이 비어있다면 잘못된 경우임
//                    return false; // NO를 출력하기 위해 false를 반환
//                }
//                stack.pop(); // 스택에서 여는 괄호를 제거
//            }
//        }
//
//        return stack.isEmpty(); // 모든 처리가 끝난 후 스택이 비어있다면 VPS가 맞음
//    }

    private static boolean isVPS(String ps) {
        int cnt = 0;

        for (char c : ps.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                cnt--;
            }

            if (cnt < 0) {
                return false;
            }
        }

        return cnt == 0;
    }
}
