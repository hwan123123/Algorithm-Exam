package sixteam.알고리즘_기초_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 각 경우에 대한 DP의 시간 복잡도는 O(N)이며, 3번 반복하기에 전체 시간 복잡도는 O(3N), 즉 O(N)
public class RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][3];
        int[][] cost = new int[N + 1][3]; // i번째 집을 j 색상으로 칠하는데 최소 비용

        final int INF = 1000 * 1000 + 1;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = INF;

        // 1번집이 각각 R, G, B로 선택 되었을때를 각각 따로 구함
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 시작하는 집이 i 색깔로 선택되었을 때로 고정
                if (i == j) {
                    cost[1][j] = dp[1][j]; // 1번집을 i 색깔로 칠해 놓음
                } else {
                    cost[1][j] = INF; // 다른 색은 선택되지 못하도록 비용을 최댓값으로 초기화
                }
            }

            // n번 집의 색은 n-1번 집의 색과 같지 않아야 함
            for (int j = 2; j <= N; j++) {
                cost[j][0] = Math.min(cost[j - 1][1], cost[j - 1][2]) + dp[j][0];
                cost[j][1] = Math.min(cost[j - 1][0], cost[j - 1][2]) + dp[j][1];
                cost[j][2] = Math.min(cost[j - 1][0], cost[j - 1][1]) + dp[j][2];
            }
            for (int j = 0; j < 3; j++) {
                if (i != j && min > cost[N][j]) { // n번째 집을 칠할 때 시작 색깔을 제외한 색깔의 비용 중 가장 작은 비용 선택
                    min = cost[N][j];
                }
            }
        }
        System.out.println(min);
    }
}
