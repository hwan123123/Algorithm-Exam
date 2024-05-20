package Exam02;

import java.util.Scanner;

public class Exam_2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(find(n));
    }

    public static int find(int n){
        int layer = 1;
        int maxNumber = 1;

        if (n == 1) {
            return 1;
        }

        while (n > maxNumber) {
            maxNumber += layer * 6;
            layer++;
        }
        return layer;
    }
}
