package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 모든 방문 조합을 탐색할 때 2^N의 시간 복잡도가 필요하고,
// dp 배열을 계산할 때 N의 시간 복잡도, 각 상태 계산 시 최대 N번 탐색하기에 N의 시간 복잡도가 필요하기에
// 전체 시간 복잡도는 O(N^2 x 2^N)
public class 외판원_순회_2 {
    static final int INF = 100000000;
    static int N;
    static int[][] W;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        dp = new int[N][(1 << N)];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], INF); // 초기 값 INF로 설정
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println(tsp(0, 1));
    }

    static int tsp(int pos, int visited) {
        if (visited == (1 << N) - 1) {
            return W[pos][0] == 0 ? INF : W[pos][0]; // 모든 도시를 방문한 경우, 시작 도시로 복귀
        }

        if (dp[pos][visited] != INF) {
            return dp[pos][visited]; // 이미 계산된 값이면 재사용
        }

        for (int i = 0; i < N; i++) {
            if ((visited & (1 << i)) == 0 && W[pos][i] != 0) { // 방문하지 않은 도시 탐색
                dp[pos][visited] = Math.min(dp[pos][visited], tsp(i, visited | (1 << i)) + W[pos][i]);
            }
        }

        return dp[pos][visited];
    }
}
