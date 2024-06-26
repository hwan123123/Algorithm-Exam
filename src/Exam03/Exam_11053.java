package Exam03;

import java.util.Scanner;

public class Exam_11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // dp 배열 초기화
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        // 계산식
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        // 최대 길이 찾기
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
            }
        }

        System.out.println(maxLength);

        // i = 1, j = 0, A[1] = 20, A[0] = 10 -- dp[1] = 2

        // i = 2, j = 0, A[2] = 10, A[0] = 10 -- dp[2] = 1
        // i = 2, j = 1, A[2] = 10, A[1] = 20 -- dp[2] = 1

        // i = 3, j = 0, A[3] = 30, A[0] = 10 -- dp[3] = 2
        // i = 3, j = 1, A[3] = 30, A[1] = 20 -- dp[3] = 3
        // i = 3, j = 2, A[3] = 30, A[2] = 10 -- dp[3] = 3

        // i = 4, j = 0, A[4] = 20, A[0] = 10 -- dp[4] = 2
        // i = 4, j = 1, A[4] = 20, A[1] = 20 -- dp[4] = 2
        // i = 4, j = 2, A[4] = 20, A[2] = 10 -- dp[4] = 2
        // i = 4, j = 3, A[4] = 20, A[3] = 30 -- dp[4] = 2

        // i = 5, j = 0, A[5] = 50, A[0] = 10 -- dp[5] = 2
        // i = 5, j = 1, A[5] = 50, A[1] = 20 -- dp[5] = 3
        // i = 5, j = 2, A[5] = 50, A[2] = 10 -- dp[5] = 3
        // i = 5, j = 3, A[5] = 50, A[3] = 30 -- dp[5] = 4
        // i = 5, j = 4, A[5] = 50, A[4] = 20 -- dp[5] = 4

        // dp = {1, 2, 1, 3, 2, 4}
    }
}
