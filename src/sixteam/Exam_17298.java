package sixteam;

import java.util.Scanner;
import java.util.Stack;

public class Exam_17298 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] result = new int[N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>(); // 오큰수를 찾지 못한 수를 저장

        // 오큰수 계산
        for (int i = 0; i < N; i++) {
            // 스택이 비어있지 않고, 현재 숫자가 스택에 있는 값보다 큰 경우
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                result[stack.pop()] = A[i]; // 스택에서 꺼낸 값의 오큰수를 현재 숫자로 설정
            }
            stack.push(i); // 현재 값을 스택에 넣음
        }

        // 스택에 남아있는 값에는 오큰수가 없으므로 -1로 설정
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
