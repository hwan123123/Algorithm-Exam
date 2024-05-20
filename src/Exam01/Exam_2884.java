package Exam01;

import java.util.Scanner;

public class Exam_2884 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int H = scanner.nextInt();
        int M = scanner.nextInt();

        int totalMinutes = H * 60 + M;

        totalMinutes -= 45;

        if (totalMinutes < 0) {
            totalMinutes += 24 * 60;
        }

        int new_H = totalMinutes / 60;
        int new_M = totalMinutes % 60;

        System.out.println(new_H + " " + new_M);
    }
}
