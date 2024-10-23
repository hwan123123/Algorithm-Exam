package sixteam.알고리즘_기초_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이중 반복문을 사용하여 N개의 자리 수와 각 자리의 0~9까지 10개의 값에 대해 계산하기에 시간 복잡도는 O(N)
public class 쉬운_계단_수 {
    public static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 길이 i, 마지막 숫자가 j인 계단 수의 개수
        long[][] dp = new long[N + 1][10];

        // 길이 1일 때
        for (int j = 1; j <= 9; j++) {
            dp[1][j] = 1;
        }

        // 점화식
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j > 0) {
                    dp[i][j] += dp[i - 1][j - 1]; // j-1에서 올 수 있는 경우
                }
                if (j < 9) {
                    dp[i][j] += dp[i - 1][j + 1]; // j+1에서 올 수 있는 경우
                }
                dp[i][j] %= MOD;
            }
        }

        long result = 0;
        for (int j = 0; j <= 9; j++) {
            result += dp[N][j];
        }

        System.out.println(result % MOD);
    }
}
