package sixteam.알고리즘_기초_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 각 테스트 케이스마다 N번 반복을 통해 DP 테이블을 채우기에 시간 복잡도는 O(T * N)
public class 스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n]; // 스티커 점수 배열
            int[][] dp = new int[n][3];
            // 0: 첫 번째 행 선택
            // 1: 두 번째 행 선택
            // 2: 아무 것도 선택 안함

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 첫 번째 열
            dp[0][0] = sticker[0][0];
            dp[0][1] = sticker[1][0];
            dp[0][2] = 0;

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]) + sticker[0][i];
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + sticker[1][i];
                dp[i][2] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            }

            // 마지막 열에서의 최대값 출력
            int result = Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));

            System.out.println(result);
        }
    }
}
