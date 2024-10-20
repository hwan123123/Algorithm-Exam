package sixteam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N번 반복하면서 각 단계에서 상수 시간의 연산을 하기 때문에 시간 복잡도는 O(N)
public class 동물원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][3];

        dp[1][0] = 1; // 사자를 배치하지 않는 경우
        dp[1][1] = 1; // 왼쪽에 사자를 배치하는 경우
        dp[1][2] = 1; // 오른쪽에 사자를 배치하는 경우

        int MOD = 9901;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD; // 사자를 배치하지 않는 경우
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD; // 왼쪽에 사자를 배치하는 경우
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD; // 오른쪽에 사자를 배치하는 경우
        }

        int result = (dp[N][0] + dp[N][1] + dp[N][2]) % MOD;

        System.out.println(result);
    }
}
