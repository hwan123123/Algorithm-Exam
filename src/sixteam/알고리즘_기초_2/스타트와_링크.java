package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 팀을 나눌 때 O(2^N-1)의 시간 복잡도가 필요하며, 팀 능력치를 계산할 때 O(N)의 시간 복잡도가 필요하기에
// 전체 시간 복잡도는 O(2^N-1 x N)
public class 스타트와_링크 {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtrack(0, 0);
        System.out.println(minDifference);
    }

    // 팀 나누기
    static void backtrack(int index, int count) {
        // N/2명을 선택했을 경우
        if (count == N / 2) {
            calculateDifference();
            return;
        }

        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    // 팀 간 능력치 차이 계산
    static void calculateDifference() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += S[i][j] + S[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeam += S[i][j] + S[j][i];
                }
            }
        }

        int difference = Math.abs(startTeam - linkTeam);
        minDifference = Math.min(minDifference, difference);
    }
}
