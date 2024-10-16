package sixteam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// DP 테이블을 미리 계산하는 데 O(n) 시간이 걸리고
// 각 테스트 케이스마다 상수 시간에 결과를 가져올 수 있으므로 전체 시간 복잡도는 O(n + T)
public class 일이삼더하기_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        long dp[] = new long[1_000_001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 1_000_000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009;
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}
