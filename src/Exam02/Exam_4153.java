package Exam02;

import java.util.Scanner;

public class Exam_4153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();

            if (A == 0 && B == 0 && C == 0) { // 0이 입력되면 종료
                break;
            }

            if (A * A + B * B == C * C || A * A + C * C == B * B || B * B + C * C == A * A) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
