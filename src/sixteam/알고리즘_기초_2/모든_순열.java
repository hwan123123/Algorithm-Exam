package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N!개의 순열을 구해야 하기 때문에 시간 복잡도는 O(N!)
public class 모든_순열 {
    static int N;
    static int[] numbers;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        visited = new boolean[N + 1];

        backtrack(0);

        System.out.println(sb.toString());
    }

    public static void backtrack(int depth) {
        if (depth == N) { // depth 값이 N에 도달하면 순열 완성
            for (int i = 0; i < N; i++) {
                sb.append(numbers[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { // 숫자 i가 아직 사용되지 않았으면 사용
                visited[i] = true;
                numbers[depth] = i;
                backtrack(depth + 1);
                visited[i] = false; // 다시 미사용 상태로 돌려줌
            }
        }
    }
}
