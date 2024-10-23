package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사탕_게임 {
    static int N;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int maxCandy = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 가로로 교환
                if (j + 1 < N) {
                    swap(i, j, i, j + 1);
                    maxCandy = Math.max(maxCandy, getMaxCandy());
                    swap(i, j, i, j + 1); // 원상복귀
                }

                // 세로로 교환
                if (i + 1 < N) {
                    swap(i, j, i + 1, j);
                    maxCandy = Math.max(maxCandy, getMaxCandy());
                    swap(i, j, i + 1, j); // 원상복귀
                }
            }
        }

        System.out.println(maxCandy);
    }

    // 사탕 교환 메서드
    private static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    // 가장 긴 연속된 사탕의 길이를 찾는 메서드
    private static int getMaxCandy() {
        int max = 0;

        // 각 행에서 최대 연속 사탕 개수 찾기
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }

        // 각 열에서 최대 연속 사탕 개수 찾기
        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (board[i][j] == board[i - 1][j]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
