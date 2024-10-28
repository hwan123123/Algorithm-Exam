package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과_M_9 {
    static int N, M;
    static int[] ans;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = new int[M];
        visited = new boolean[N];
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);

        System.out.println(sb.toString());
    }

    private static void dfs(int count) {
        if (count == M) { //원하는 만큼 뽑았으면 탈출
            for (int i = 0; i < M; i++) {
                sb.append(ans[i]).append(" ");

            }
            sb.append("\n");
            return;
        } else {
            int before = 0; // 이전에 뽑았던 값을 저장
            for (int i = 0; i < N; i++) {
                if (visited[i]) {  // 뽑았던 값이면
                    continue;
                } else if (before != arr[i] ) {
                    visited[i] = true;
                    ans[count] = arr[i];
                    before = arr[i];
                    dfs(count + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
