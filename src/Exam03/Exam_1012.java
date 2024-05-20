package Exam03;

import java.util.*;

public class Exam_1012 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            int[][] field = new int[M][N];

            for (int k = 0; k < K; k++) {
                int X = scanner.nextInt();
                int Y = scanner.nextInt();
                field[X][Y] = 1;
            }

            int numEarthworms = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (field[i][j] == 1) {
                        dfs(i, j, field);
                        numEarthworms++;
                    }
                }
            }

            System.out.println(numEarthworms);
        }

        scanner.close();
    }

    static void dfs(int x, int y, int[][] field) {
        field[x][y] = 0; // 방문한 위치는 0으로 표시하여 중복 방문을 방지

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < field.length && ny >= 0 && ny < field[0].length && field[nx][ny] == 1) {
                dfs(nx, ny, field);
            }
        }
    }
}
