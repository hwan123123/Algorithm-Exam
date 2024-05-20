package Exam01;

import java.util.Scanner;

public class Exam_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        String input = sc.next();

        int sum = 0;

        for (int i = 0; i < a; i++) {
            int num = input.charAt(i) - '0';
            sum += num;
        }

        System.out.println(sum);
    }
}

