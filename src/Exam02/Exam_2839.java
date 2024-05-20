package Exam02;

import java.util.Scanner;

public class Exam_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;

        while (N > 0) {
            if (N % 5 == 0) {
                count += N / 5;
                N = 0;
            } else if (N >= 3) {
                N -= 3;
                count++;
            } else {
                count = -1;
                break;
            }
        }
        System.out.println(count);
    }
}
