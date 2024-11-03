package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 팀을 나눌 때 O(2^N-1)의 시간 복잡도가 필요하며, 팀 능력치를 계산할 때 O(N^2)의 시간 복잡도가 필요하기에
// 전체 시간 복잡도는 O(2^N-1 x N^2)
public class 링크와_스타트 {
    static int N;
    static int[][] S;
    static boolean[] team;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        team = new boolean[N];

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
    static void backtrack(int index, int teamCount) {
        // 최소 한 명씩 두 팀에 나눠졌을 때
        if (index == N) {
            if (teamCount > 0 && teamCount < N) {
                calculateDifference();
            }
            return;
        }

        // 현재 사람을 스타트 팀에 넣는 경우
        team[index] = true;
        backtrack(index + 1, teamCount + 1);

        // 현재 사람을 링크 팀에 넣는 경우
        team[index] = false;
        backtrack(index + 1, teamCount);
    }

    // 팀 간 능력치 차이 계산
    static void calculateDifference() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (team[i] && team[j]) {
                    startTeam += S[i][j] + S[j][i];
                } else if (!team[i] && !team[j]) {
                    linkTeam += S[i][j] + S[j][i];
                }
            }
        }

        int difference = Math.abs(startTeam - linkTeam);
        minDifference = Math.min(minDifference, difference);
    }
}
