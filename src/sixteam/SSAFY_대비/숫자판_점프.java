package sixteam.SSAFY_대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 5x5 숫자판에서 최대 깊이 5까지 탐색을 하기에 전체 시간 복잡도는 O(5 x 5 x 4^5)
public class 숫자판_점프 {
    static int[][] board = new int[5][5];
    static Set<String> uniqueNumbers = new HashSet<>();
    static int[] dx = {0, 1, 0, -1}; // 이동 방향 (상,우,하,좌)
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, "", 0);
            }
        }

        System.out.println(uniqueNumbers.size());
    }

    // 6자리 수 생성
    public static void dfs(int x, int y, String number, int depth) {
        if (depth == 6) {
            uniqueNumbers.add(number);
            return;
        }

        number += board[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                dfs(nx, ny, number, depth + 1);
            }
        }
    }
}
