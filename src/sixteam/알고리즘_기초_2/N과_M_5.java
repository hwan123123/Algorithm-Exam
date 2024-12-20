package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과_M_5 {
    static int[] arr;
    static int N, M;
    static boolean[] visited;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        ans = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);
        System.out.print(sb.toString());
    }

    public static void dfs(int depth) {
        if (depth == M){
            for (int i = 0; i < M; i++){
                sb.append(ans[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++){
            if (!visited[i]){
                visited[i] = true;
                ans[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
