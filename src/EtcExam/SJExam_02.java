package EtcExam;

import java.util.Arrays;

public class SJExam_02 {
    public int[][] solution(int n) {
        int[][] result = new int[n][n];
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int num = 1;
        int direction = 1;
        int row = 0;
        int col = 0;

        while (n <= 4 * 4) {
            result[row][col] = n++;
            int nextRow = row + dr[direction];
            int nextCol = col + dc[direction];

            if (nextRow < 0 || nextRow >= 4 || nextCol < 0 || nextCol >= 4 || result[nextRow][nextCol] == 0) {
                direction = (direction + 1) % 4;
                nextRow = row + dr[direction];
                nextCol = col + dc[direction];
            }
            row = nextRow;
            col = nextCol;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] result = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}};
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
