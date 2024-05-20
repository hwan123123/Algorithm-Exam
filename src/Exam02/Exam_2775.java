package Exam02;

import java.util.Scanner;

public class Exam_2775 {
    static int[][] residents = new int[15][15];

    public static int countResidents(int k, int n) {
        if (residents[k][n] > 0)
            return residents[k][n];

        if (k == 0)
            return residents[k][n] = n;

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += countResidents(k - 1, i);
        }
        return residents[k][n] = sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(countResidents(k, n));
        }

        scanner.close();
    }
}