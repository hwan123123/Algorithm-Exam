package Exam03;

import java.util.Scanner;

public class Exam_1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // dp 배열 초기화
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = i; // 최대값으로 초기화 (모두 1^2로 이루어진 경우)
        }

        // DP 배열 갱신
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }

        System.out.println(dp[N]);

        // N = 1, j = 1, square = 1 -- dp[1] = 1

        // N = 2, j = 1, square = 1 -- dp[2] = 2

        // N = 3, j = 1, square = 1 -- dp[3] = 3

        // N = 4, j = 1, square = 1 -- dp[4] = 4
        // N = 4, j = 2, square = 4 -- dp[4] = 1

        // N = 5, j = 1, square = 1 -- dp[5] = 2
        // N = 5, j = 2, square = 4 -- dp[5] = 2

        // N = 6, j = 1, square = 1 -- dp[6] = 3
        // N = 6, j = 2, square = 4 -- dp[6] = 3

        // N = 7, j = 1, square = 1 -- dp[7] = 4
        // N = 7, j = 2, square = 4 -- dp[7] = 4

        // N = 8, j = 1, square = 1 -- dp[8] = 5
        // N = 8, j = 2, square = 4 -- dp[8] = 2

        // N = 9, j = 1, square = 1 -- dp[9] = 3
        // N = 9, j = 2, square = 4 -- dp[9] = 3
        // N = 9, j = 3, square = 9 -- dp[9] = 1

        // N = 10, j = 1, square = 1 -- dp[10] = 2
        // N = 10, j = 2, square = 4 -- dp[10] = 2
        // N = 10, j = 3, square = 9 -- dp[10] = 2

        // N = 11, j = 1, square = 1 -- dp[11] = 3
        // N = 11, j = 2, square = 4 -- dp[11] = 3
        // N = 11, j = 3, square = 9 -- dp[11] = 3
    }
}
