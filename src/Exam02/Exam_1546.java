package Exam02;

import java.util.Scanner;

public class Exam_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] scores = new int[N];

        for (int i = 0; i < scores.length; i++) {
            scores[i] = sc.nextInt();
        }

        int M = scores[0];
        for (int i = 1; i < N; i++) {
            if (scores[i] > M) {
                M = scores[i];
            }
        }

        double[] manipulate = new double[N];
        for (int i = 0; i < N; i++) {
            manipulate[i] = (double) scores[i] / M * 100;
        }

        double sum = 0;
        for (double score : manipulate) {
            sum += score;
        }

        double average = sum / N;

        System.out.println(average);
    }
}
