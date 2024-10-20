package sixteam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이중 반복문을 사용하여 각 원소에 대해 그 이전 원소들과 비교하므로 시간 복잡도는 O(n^2)
public class 가장_큰_증가하는_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 수열의 크기
        int[] A = new int[n]; // 수열 A
        int[] dp = new int[n]; // DP 테이블

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 각 원소가 자신을 포함하는 증가 부분 수열의 합
        for (int i = 0; i < n; i++) {
            dp[i] = A[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                    // dp[i]는 이전까지의 원소들 중 자신보다 작은 값을 찾아서
                    // 그 원소까지의 최대 부분 수열 합에 A[i]를 더하는 방식으로 계산
                    // A[i] > A[j]인 경우, dp[i] = max(dp[i], dp[j] + A[i])
                }
            }
        }

        // 최대값 찾기
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }

        System.out.println(maxSum);
    }
}
