package Exam02;

import java.util.Scanner;

public class Exam_3036 {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] radii = new int[n];
        for (int i = 0; i < n; i++) {
            radii[i] = scanner.nextInt();
        }

        int firstRadius = radii[0];

        for (int i = 1; i < n; i++) {
            int currentRadius = radii[i];
            int numerator = firstRadius;
            int denominator = currentRadius;

            int gcd = gcd(numerator, denominator);

            System.out.println((numerator / gcd) + "/" + (denominator / gcd));
        }
    }
}
