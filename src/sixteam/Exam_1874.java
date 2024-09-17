package sixteam;

import java.util.Scanner;
import java.util.Stack;

public class Exam_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = sc.nextInt(); // 수열의 크기 입력
        int[] sequence = new int[n]; // 수열을 저장할 배열 생성

        for (int i = 0; i < n; i++) {
            sequence[i] = sc.nextInt(); // 수열 입력
        }

        int currentNumber = 1; // 오름차순을 위해 스택에 넣을 숫자 초기화
        boolean isPossible = true; // 수열 생성 가능 여부 확인

        for (int i = 0; i < n; i++) {
            int target = sequence[i]; // 현재 목표 숫자

            while (currentNumber <= target) { // 현재 숫자가 목표 숫자 이하가 될 때까지 push
                stack.push(currentNumber++); // push push baby
                result.append("+\n"); // 연산 결과 입력
            }

            if (stack.peek() == target) { // 스택의 최상위 값이 목표 숫자와 같은 경우
                stack.pop(); // 스택에서 pop
                result.append("-\n"); // 연산 결과 입력
            } else {
                isPossible = false; // 스택의 최상위 값이 목표 숫자와 다르면 불가능
                break;
            }
        }

        if (isPossible) { // 수열 생성이 가능하다면 결과 출력
            System.out.println(result);
        } else { // 아니라면 NO 출력
            System.out.println("NO");
        }
    }
}
