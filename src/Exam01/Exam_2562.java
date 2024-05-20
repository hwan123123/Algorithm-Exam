package Exam01;

import java.util.Scanner;

public class Exam_2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[9];

        for (int i = 0; i < 9; i++) {
            numbers[i] = sc.nextInt();
        }

        int max = numbers[0];
        int result = 0;

        for (int i = 1; i < 9; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                result = i;
            }
        }

        System.out.println(max);
        System.out.println(result + 1);
    }
}
