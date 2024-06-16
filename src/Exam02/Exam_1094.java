package Exam02;

import java.util.Scanner;

public class Exam_1094 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();

        int stick = 64;
        int count = 0;

        while (X > 0) {
            if (stick > X) {
                stick /= 2;
            } else {
                count++;
                X -= stick;
            }
        }

        System.out.println(count);
    }
}