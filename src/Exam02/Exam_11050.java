package Exam02;

import java.util.Scanner;

public class Exam_11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int result1 = 1;
        int result2 = 1;
        int result3 = 1;


        for (int i = 1; i <= N; i++) {
            result1 *= i;
        }

        for (int i = 1; i <= K; i++) {
            result2 *= i;
        }

        for (int i = 1; i <= N - K; i++) {
            result3 *= i;
        }

        System.out.println(result1 / (result2 * result3));
    }
}
