package sixteam.알고리즘_기초_1;

import java.util.Scanner;

public class 타일링_2xn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        // 점화식
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
