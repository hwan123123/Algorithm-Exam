package sixteam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 두 개의 변수(N과 K)를 기반으로 DP 테이블을 채워야 하므로, 시간 복잡도는 O(N * K)
public class 합분해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // k개의 숫자로 n을 만들 수 있는 경우의 수
        int[][] dp = new int[K + 1][N + 1];
        int MOD = 1_000_000_000;

        // k가 1일 때는 n을 만드는 경우는 1가지
        for (int i = 0; i <= N; i++) {
            dp[1][i] = 1;
        }

        for (int k = 2; k <= K; k++) {
            for (int n = 0; n <= N; n++) {
                for (int x = 0; x <= n; x++) {
                    dp[k][n] = (dp[k][n] + dp[k - 1][n - x]) % MOD;
                    // 점화식: dp[k][n] = dp[k-1][n] + dp[k][n-1]
                    // dp[k-1][n] = 마지막 수가 0인 경우
                    // dp[k][n-1] = 마지막 수가 1 이상인 경우
                }
            }
        }

        System.out.println(dp[K][N]);
    }
}
