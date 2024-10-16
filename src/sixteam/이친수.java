package sixteam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N에 대해 1부터 N까지 차례대로 값을 채워나가기 때문에 시간 복잡도는 O(N)
public class 이친수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][2];

        // 초기값
        dp[1][0] = 0;
        dp[1][1] = 1;

        // 점화식
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        System.out.println(dp[N][0] + dp[N][1]);
    }
}

// dp[i][0]: i번째 자리수가 0인 이친수의 개수
// dp[i][1]: i번째 자리수가 1인 이친수의 개수

// dp[i][0] = dp[i-1][0] + dp[i-1][1] (마지막 자리가 0인 경우, 그 앞은 0이나 1 모두 가능)
// dp[i][1] = dp[i-1][0] (마지막 자리가 1인 경우, 그 앞은 0만 가능)

// dp[1][0] = 0 (1자리에서 0으로 시작할 수 없음)
// dp[1][1] = 1 (1자리에서 1로 시작할 수 있음)