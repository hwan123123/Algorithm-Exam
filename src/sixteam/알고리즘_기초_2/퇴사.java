package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 각 날에 대해 한 번씩만 상태를 업데이트 하기에 시간 복잡도는 O(N)
public class 퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken()); // 상담에 걸리는 기간
            P[i] = Integer.parseInt(st.nextToken()); // 상담으로 얻을 수 있는 금액
        }

        for (int i = 1; i <= N; i++) {
            // i일에 상담을 하지 않는 경우
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            // i일에 상담을 하는 경우
            if (i + T[i] <= N + 1) { // 퇴사 전 상담이 끝나는 경우만 고려
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
        }

        // N+1일 이후에 얻을 수 있는 최대 이익 출력
        System.out.println(dp[N + 1]);
    }
}
