package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주어진 k개의 수 중에서 6개의 수를 선택해야 하므로, 시간 복잡도는 이항 계수로 표현됨
// 시간 복잡도: O(k! / (6! x (k-6)!)
public class 로또 {
    static int k;
    static int[] S;
    static int[] combination;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                break;
            }

            S = new int[k];
            combination = new int[6];

            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0, sb);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int start, int depth, StringBuilder sb) {
        if (depth == 6) { // 조합이 완성된 경우
            for (int i = 0; i < 6; i++) {
                sb.append(combination[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            combination[depth] = S[i];
            dfs(i + 1, depth + 1, sb);
        }
    }
}
