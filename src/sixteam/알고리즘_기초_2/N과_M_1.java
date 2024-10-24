package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N개의 숫자 중에서 M개의 숫자를 고르는 경우의 수는 P(N, M) = N! / (N-M)! 이기에
// 시간 복잡도는 O(N! / (N-M)!)
public class N과_M_1 {
    static int N, M;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N: 1부터 N까지의 자연수
        M = Integer.parseInt(st.nextToken()); // M: 선택할 수열의 길이

        result = new int[M]; // 선택한 수열을 저장할 배열
        visited = new boolean[N + 1]; // 숫자가 선택되었는지 여부를 저장하는 배열

        // 백트래킹 시작
        backtrack(0);
    }

    // 현재 수열의 길이가 depth인 상태에서 실행
    public static void backtrack(int depth) {
        // 수열의 길이가 M이 되면 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        // 1부터 N까지의 수 중에서 선택 (사전 순으로 탐색)
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { // i가 아직 선택되지 않은 경우
                visited[i] = true; // i를 선택한 것으로 표시
                result[depth] = i; // 수열의 현재 위치에 i 저장
                backtrack(depth + 1); // 다음 숫자를 선택하기 위해 재귀 호출
                visited[i] = false; // 선택을 취소하고 다음 경우를 탐색
            }
        }
    }
}
