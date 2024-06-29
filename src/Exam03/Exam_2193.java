package Exam03;

import java.util.Scanner;

public class Exam_2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // dp 배열 선언 및 초기화
        long[] dp = new long[N+1];
        dp[1] = 1;
        if (N >= 2) dp[2] = 1;

        // dp 배열 채우기
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);
    }
}
