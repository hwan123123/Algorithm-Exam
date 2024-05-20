package Exam01;

import java.util.Arrays;
import java.util.Scanner;

public class Exam_2475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a[] = new int[5];
        int sum = 0;
        int result = 0;

        for (int i = 0; i < 5; i++) {
            a[i] = sc.nextInt();
            sum += a[i] * a[i];
        }
        result = sum % 10;
        System.out.println(result);
    }
}
