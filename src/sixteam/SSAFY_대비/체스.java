package sixteam.SSAFY_대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Queen의 공격 범위 : O(q x (n + m))
// Knight의 공격 범위 : O(k)
// Pawn 위치 처리 : O(p)
// 안전한 칸 계산 : O(n x m)
// 전체 시간 복잡도 : O(q x (n + m) + k + p + (n x m))
public class 체스 {
    static int[] knight_X = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] knight_Y = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] queen_X = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] queen_Y = {0, 1, 1, 1, 0, -1, -1, -1};
    static int n, m;
    static int[][] board;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            board = new int[n][m];

            // Queen 위치 설정
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int i = 0; i < k; i++) {
                int y = Integer.parseInt(st.nextToken()) - 1;
                int x = Integer.parseInt(st.nextToken()) - 1;
                board[y][x] = 1;  // Queen 위치 표시
            }

            // Knight 위치 설정
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            for (int i = 0; i < k; i++) {
                int y = Integer.parseInt(st.nextToken()) - 1;
                int x = Integer.parseInt(st.nextToken()) - 1;
                board[y][x] = 2;  // Knight 위치 표시
            }

            // Pawn 위치 설정
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            for (int i = 0; i < k; i++) {
                int y = Integer.parseInt(st.nextToken()) - 1;
                int x = Integer.parseInt(st.nextToken()) - 1;
                board[y][x] = 3;  // Pawn 위치 표시
            }

            // Queen과 Knight 이동 경로 표시
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 1)
                        Queen(j, i);
                    else if (board[i][j] == 2)
                        Knight(j, i);
                }
            }

            // 안전한 칸 세기
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 0)
                        count++;
                }
            }

            System.out.println(count);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void Knight(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int knightX = x + knight_X[i];
            int knightY = y + knight_Y[i];

            if (knightX >= 0 && knightX < m && knightY < n && knightY >= 0) {
                if (board[knightY][knightX] == 0)
                    board[knightY][knightX] = -1;  // 공격 위치 표시
            }
        }
    }

    public static void Queen(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int queenX = x + queen_X[i];
            int queenY = y + queen_Y[i];

            while (queenX >= 0 && queenX < m && queenY < n && queenY >= 0 && board[queenY][queenX] <= 0) {
                board[queenY][queenX] = -1;  // 공격 위치 표시
                queenX += queen_X[i];
                queenY += queen_Y[i];
            }
        }
    }
}
