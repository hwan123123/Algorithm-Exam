package sixteam.알고리즘_기초_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이중 반복문을 사용하기에 외부 루프는 O(√N), 내부 루프는 O(N)으로 전체 시간 복잡도는 O(N√N)
public class 제곱수의_합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 최소 항의 개수 배열
        int[] dp = new int[N + 1];

        // 자연수 N에서 N을 만들 수 있는 최대 값은 1의 제곱의 합으로 표현한 N개
        for (int i = 1; i <= N; i++) {
            dp[i] = i; // 최악의 경우 1^2의 합으로만 구성하는 경우
        }

        for (int i = 1; i * i <= N; i++) {
            int square = i * i;
            for (int j = square; j <= N; j++) {
                dp[j] = Math.min(dp[j], dp[j - square] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}
