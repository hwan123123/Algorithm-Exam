package Exam03;

import java.util.Scanner;

public class Exam_1003 {
    static int[][] memo = new int[41][2]; // 메모이제이션 배열

    // 피보나치 수열 계산 함수
    static int[] fibonacci(int n) {
        if (n == 0) {
            return new int[]{1, 0};
        } else if (n == 1) {
            return new int[]{0, 1};
        }

        // 이미 계산한 값이 있다면 메모이제이션된 값을 반환
        if (memo[n][0] != 0 || memo[n][1] != 0) {
            return memo[n];
        }

        // 계산이 필요한 경우, 재귀 호출하여 계산하고 결과를 메모이제이션
        int[] fib1 = fibonacci(n - 1);
        int[] fib2 = fibonacci(n - 2);

        int[] result = {fib1[0] + fib2[0], fib1[1] + fib2[1]};
        memo[n] = result;

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // 테스트 케이스의 개수

        memo[0] = new int[]{1, 0}; // fibonacci(0) 초기화
        memo[1] = new int[]{0, 1}; // fibonacci(1) 초기화

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt(); // N값 입력
            int[] result = fibonacci(N); // 피보나치 수열 계산

            // 결과 출력
            System.out.println(result[0] + " " + result[1]);
        }

        scanner.close();
    }
}
