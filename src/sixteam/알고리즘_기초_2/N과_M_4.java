package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과_M_4 {
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        backtrack(1, 0, new int[M]);

        System.out.print(sb.toString());
    }

    public static void backtrack(int start, int depth, int[] sequence) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(sequence[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // start부터 N까지의 숫자를 선택
        for (int i = start; i <= N; i++) {
            sequence[depth] = i; // 현재 위치에 숫자 i 저장
            backtrack(i, depth + 1, sequence); // 비내림차순을 위해 i 이상을 사용
        }
    }
}
