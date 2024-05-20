package Exam01;

import java.util.Scanner;

public class Exam_27866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int i = sc.nextInt();

        if (i > 0 && str.length() >= i) {
            char letter = str.charAt(i - 1);
            System.out.println(letter);
        }
    }
}
