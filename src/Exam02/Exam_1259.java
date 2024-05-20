package Exam02;

import java.util.Scanner;

public class Exam_1259 {
    public static int reverse(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num = num / 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int num = sc.nextInt();

            if (num == 0) {
                break;
            }

            String result = (num == reverse(num)) ? "yes" : "no";
            System.out.println(result);
        }
    }
}
