package Exam02;

import java.util.Scanner;

public class Exam_1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int zeroCount = 0;

        for (int i = 5; i <= N; i *= 5) {
            zeroCount += N / i;
        }

        System.out.println(zeroCount);
    }
}
