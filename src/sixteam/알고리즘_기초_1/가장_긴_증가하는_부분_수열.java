package sixteam.알고리즘_기초_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이중 반복문을 사용하기 때문에 시간 복잡도는 O(N^2)
public class 가장_긴_증가하는_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; // 각 원소를 마지막으로 하는 최장 길이 초기값은 1
        }

        // 동적 계획법 적용
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }

        System.out.println(maxLength);
    }
}

// i = 1, j = 0, A[1] = 20, A[0] = 10 -- dp[1] = 2

// i = 2, j = 0, A[2] = 10, A[0] = 10 -- dp[2] = 1
// i = 2, j = 1, A[2] = 10, A[1] = 20 -- dp[2] = 1

// i = 3, j = 0, A[3] = 30, A[0] = 10 -- dp[3] = 2
// i = 3, j = 1, A[3] = 30, A[1] = 20 -- dp[3] = 3
// i = 3, j = 2, A[3] = 30, A[2] = 10 -- dp[3] = 3

// i = 4, j = 0, A[4] = 20, A[0] = 10 -- dp[4] = 2
// i = 4, j = 1, A[4] = 20, A[1] = 20 -- dp[4] = 2
// i = 4, j = 2, A[4] = 20, A[2] = 10 -- dp[4] = 2
// i = 4, j = 3, A[4] = 20, A[3] = 30 -- dp[4] = 2

// i = 5, j = 0, A[5] = 50, A[0] = 10 -- dp[5] = 2
// i = 5, j = 1, A[5] = 50, A[1] = 20 -- dp[5] = 3
// i = 5, j = 2, A[5] = 50, A[2] = 10 -- dp[5] = 3
// i = 5, j = 3, A[5] = 50, A[3] = 30 -- dp[5] = 4
// i = 5, j = 4, A[5] = 50, A[4] = 20 -- dp[5] = 4

// dp = {1, 2, 1, 3, 2, 4}