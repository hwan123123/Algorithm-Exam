package sixteam.알고리즘_기초_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 복잡도: O(N)
public class 포도주_시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] wine = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        // n이 1인 경우 바로 출력
        if (n == 1) {
            System.out.println(wine[1]);
            return;
        }

        int[] dp = new int[n + 1];

        // 초기값 설정
        dp[1] = wine[1]; // 첫 번째 잔을 마시는 경우
        if (n > 1) {
            dp[2] = wine[1] + wine[2]; // 첫 번째와 두 번째 잔을 모두 마시는 경우
        }
        if (n > 2) {
            dp[3] = Math.max(wine[1] + wine[2], Math.max(wine[1] + wine[3], wine[2] + wine[3]));
            // 세 번째 잔까지 고려했을 때의 최댓값
        }

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]));
            // dp[i-1]: i번 째 잔을 마시지 않는 경우
            // dp[i-2] + wine[i]: i번 째 잔을 마시고, i-1번 째 잔은 마시지 않는 경우
            // dp[i-3] + wine[i-1] + wine[i]: i번 째와 i-1번 째 잔을 마시고, i-2번 째 잔은 마시지 않는 경우
            // 점화식: dp[i] = max(dp[i-1], dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i])
        }

        System.out.println(dp[n]);
    }
}
