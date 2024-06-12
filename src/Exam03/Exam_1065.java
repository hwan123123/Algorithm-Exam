package Exam03;

import java.util.Scanner;

public class Exam_1065 {
    public static boolean Hansu(int number) {
        if (number < 100) {
            return true;
        }

        // 백의 자리
        int first = number / 100;
        // 십의 자리
        int second = (number / 10) % 10;
        // 일의 자리
        int third = number % 10;

        // 등차수열 확인
        return (first - second) == (second - third);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (Hansu(i)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
