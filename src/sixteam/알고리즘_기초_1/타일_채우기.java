package sixteam.알고리즘_기초_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// dp[i]를 계산할 때 그보다 작은 값들에 대해 반복문이 진행되면서 N/2회의 연산이 진행되며,
// 이중 반복문에서 외부 반복문이 N회, 내부 반복문이 N/2회의 연산이 진행되기에
// 전체 시간 복잡도는 O(N^2)
public class 타일_채우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        if (N >= 2) {
            dp[2] = 3; // 3×2 벽을 채우는 경우는 3가지
        }

        if (N >= 4) {
            dp[0] = 1; // 3x0 벽은 타일을 하나도 놓지 않는 방법
            for (int i = 4; i <= N; i += 2) { // N이 홀수인 경우 타일을 채울 수 없기에 2씩 증가
                dp[i] = dp[i - 2] * 3; // 기본 계산
                // 점화식: dp[n] = 3 * dp[n−2] + 2(dp[n−4] + dp[n−6] + ...)
                for (int j = i - 4; j >= 0; j -= 2) {
                    dp[i] += dp[j] * 2; // 추가 계산
                }
            }
        }

        System.out.println(dp[N]);
    }
}

/*
dp[0] = 1 / 아무것도 놓지 않는 경우도 한 가지의 방법임
dp[1] = 0 / 3x1 벽을 채울 수 있는 방법은 없음
dp[2] = 3 / 3x2 벽을 채우는 방법은 3가지
*/