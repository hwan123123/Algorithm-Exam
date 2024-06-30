package Exam03;

import java.util.Scanner;

public class Exam_1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int currentMax = arr[0];
        int totalMax = arr[0];

        for (int i = 1; i < n; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            if (currentMax > totalMax) {
                totalMax = currentMax;
            }
        }

        System.out.println(totalMax);
    }
}
