package sixteam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// dp[i][1], dp[i][2], dp[i][3]을 계산하는 과정에서 매번 O(1)의 연산이 필요하며, i는 n까지 계산하기에
// 시간복잡도는 O(n + T)
public class 일이삼더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[12];

        dp[1] = 1; // 1을 만드는 방법 1가지
        dp[2] = 2; // 2를 만드는 방법 2가지
        dp[3] = 4; // 3을 만드는 방법 4가지

        // 점화식
        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
