package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과_M_6 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static boolean[] visit;
    static int[] arr;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        input = new int[N];
        for(int i = 0; i< N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        visit = new boolean[N];
        arr = new int[M];
        dfs(0,0);
        System.out.println(sb);
    }

    private static void dfs(int depth, int start) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = input[i];
                dfs(depth + 1,i);
                visit[i] = false;
            }
        }
    }
}
