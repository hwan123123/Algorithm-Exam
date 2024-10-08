package sixteam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 외부 루프는 N번 반복되고, 내부 루프는 i번씩 반복되기에 이중 반복문에 따라 시간 복잡도는 O(N^2)
public class 카드_구매하기_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 카드팩 가격
        int[] P = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        // DP 배열을 큰 값으로 초기화 (최소값을 구하기 때문에 충분히 큰 값으로 초기화)
        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0; // 0개의 카드를 구매하는 경우 비용은 0원

        // 점화식
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + P[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
