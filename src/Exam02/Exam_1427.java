package Exam02;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Exam_1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Character[] digits = new Character[input.length()];
        for (int i = 0; i < input.length(); i++) {
            digits[i] = input.charAt(i);
        }

        Arrays.sort(digits, Collections.reverseOrder());

        StringBuilder sortedNumber = new StringBuilder();
        for (Character digit : digits) {
            sortedNumber.append(digit);
        }

        System.out.println(sortedNumber.toString());
    }
}