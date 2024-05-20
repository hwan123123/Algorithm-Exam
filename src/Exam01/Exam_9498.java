package Exam01;

import java.util.Scanner;

public class Exam_9498 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n >= 90 && n <= 100) {
            System.out.println("A");
        } else if (n >= 80 && n < 90) {
            System.out.println("B");
        } else if (n >= 70 && n <= 80) {
            System.out.println("C");
        } else if (n >= 60 && n <= 70) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
