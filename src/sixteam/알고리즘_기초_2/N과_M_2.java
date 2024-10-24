package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1부터 N까지의 숫자 중에서 M개의 숫자를 선택하는 문제로 시간 복잡도는
// 경우의 수인 C(N, M) = N! / M!(N-M)! 이므로, 시간 복잡도는 O(N! / M!(N-M)!)
public class N과_M_2 {
    static int N, M;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N: 1부터 N까지의 자연수
        M = Integer.parseInt(st.nextToken()); // M: 선택할 수열의 길이

        result = new int[M]; // 선택한 수열을 저장할 배열

        // 1부터 시작해서 오름차순으로 선택
        backtrack(1, 0);
    }

    // start는 선택할 숫자의 시작점, depth는 현재 수열의 길이
    public static void backtrack(int start, int depth) {
        // 수열의 길이가 M이 되면 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        // start부터 N까지의 수 중에서 선택 (오름차순 탐색)
        for (int i = start; i <= N; i++) {
            result[depth] = i; // 수열의 현재 위치에 i 저장
            backtrack(i + 1, depth + 1); // i보다 큰 숫자들로 다음 선택 진행
        }
    }
}
