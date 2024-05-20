package Exam01;

import java.util.Scanner;

public class Exam_1000 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a, b;

        System.out.print("A 값을 입력하시오 : ");
        a = sc.nextInt();
        System.out.print("B 값을 입력하시오 : ");
        b = sc.nextInt();

        System.out.println("A + B의 결과값은 " + (a + b) + "입니다.");
    }
}
