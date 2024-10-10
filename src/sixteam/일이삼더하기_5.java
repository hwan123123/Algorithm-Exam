package sixteam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이삼더하기_5 {
    public static final int MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int maxN = 100000;
        long[][] dp = new long[maxN + 1][4]; // dp[i][j] -> i를 만들 때 마지막으로 사용한 숫자가 j인 경우의 방법 수

        // 초기값 설정
        if (maxN >= 1) dp[1][1] = 1; // 1을 만들 때 마지막 숫자가 1인 경우
        if (maxN >= 2) dp[2][2] = 1; // 2를 만들 때 마지막 숫자가 2인 경우
        if (maxN >= 3) dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1; // 3을 만들 때 마지막 숫자가 1, 2, 3인 경우 각각

        // 점화식
        for (int i = 4; i <= maxN; i++) {
            dp[i][1] = (dp[i-2][2] + dp[i-3][3]) % MOD;
            dp[i][2] = (dp[i-1][1] + dp[i-3][3]) % MOD;
            dp[i][3] = (dp[i-1][1] + dp[i-2][2]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            long result = (dp[n][1] + dp[n][2] + dp[n][3]) % MOD;
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
