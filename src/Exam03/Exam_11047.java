package Exam03;

import java.util.Scanner;

public class Exam_11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] A = new int[N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // 계산식
        for (int i = N - 1; i >= 0; i--) {
            if (A[i] <= K) {
                count += K / A[i];
                K %= A[i];
            }
        }

        // 출력
        System.out.println(count);
    }
}
