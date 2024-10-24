package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int maxSum = 0;
    static int[] dx = {0, 1, 0, -1}; // 상하좌우 이동
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 좌표에 대해 탐색 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);  // DFS로 테트로미노 모양 탐색
                visited[i][j] = false;
                checkExtraShapes(i, j);   // 'ㅗ' 모양 별도 처리
            }
        }

        System.out.println(maxSum);
    }

    // 테트로미노의 모양을 확인하는 메서드
    static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + map[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    // 'ㅗ, ㅜ, ㅏ, ㅓ' 모양을 처리하는 메서드
    static void checkExtraShapes(int x, int y) {
        if (x >= 1 && y >= 1 && y + 1 < M) // 'ㅗ' 모양
            maxSum = Math.max(maxSum, map[x][y] + map[x-1][y] + map[x][y-1] + map[x][y+1]);
        if (x + 1 < N && y >= 1 && y + 1 < M) // 'ㅜ' 모양
            maxSum = Math.max(maxSum, map[x][y] + map[x+1][y] + map[x][y-1] + map[x][y+1]);
        if (x >= 1 && x + 1 < N && y + 1 < M) // 'ㅏ' 모양
            maxSum = Math.max(maxSum, map[x][y] + map[x-1][y] + map[x+1][y] + map[x][y+1]);
        if (x >= 1 && x + 1 < N && y >= 1) // 'ㅓ' 모양
            maxSum = Math.max(maxSum, map[x][y] + map[x-1][y] + map[x+1][y] + map[x][y-1]);
    }
}
