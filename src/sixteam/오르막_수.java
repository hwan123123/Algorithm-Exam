package sixteam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이중 반복문이지만 내부 반복문은 최대 10번만 반복하기 떄문에 시간 복잡도는 O(N * 10 * 10)이지만, 실제 시간 복잡도는 O(N)
public class 오르막_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int MOD = 10007; // 결과 값에 모듈러 연산을 적용해 너무 큰 값을 방지함
        int[][] dp = new int[N + 1][10];

        // 길이가 1일 때는 각 숫자가 0~9까지 1개의 오르막 수를 가진다
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        // 길이가 2 이상일 때 가능한 오르막 수 계산
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = 0;
                // dp[i][j]: 길이가 i이고 마지막 숫자가 j인 오르막 수의 개수 저장 배열
                for (int k = 0; k <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][k]) % MOD;
                    // 점화식: dp[i][j] = dp[i-1][0] + dp[i-1][1] + ... + dp[i-1][j]
                }
            }
        }

        int result = 0;

        // 모든 자릿수가 가능한 오르막 수 계산
        for (int i = 0; i < 10; i++) {
            result = (result + dp[N][i]) % MOD;
        }

        System.out.println(result);
    }
}
