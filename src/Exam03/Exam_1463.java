package Exam03;

import java.util.Scanner;

public class Exam_1463 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        int[] dp = new int[N + 1];

        // dp[1] = 0; // 1은 이미 1이므로 연산 횟수가 0
        for (int i = 2; i <= N; i++) {
            // 1을 빼는 경우
            dp[i] = dp[i - 1] + 1;

            // 2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 3으로 나누어 떨어지는 경우
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}
