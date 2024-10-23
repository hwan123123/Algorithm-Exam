package sixteam.알고리즘_기초_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// DP 테이블을 채우는 데에는 n번의 반복이 필요하기에 시간복잡도는 O(n)
public class 타일링_2xn2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        dp[1] = 1; // 2x1을 채우는 경우는 1가지
        if (n >= 2) {
            dp[2] = 3; // 2x2를 채우는 경우는 3가지 (1x2 2개, 2x1 2개, 2x2 1개)
        }

        // 점화식
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
