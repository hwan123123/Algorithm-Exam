package Exam03;

import java.util.Scanner;

public class Exam_1541 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();

        System.out.println(minimize(number));
    }

    public static int minimize(String number) {
        String[] parts = number.split("-");

        int firstPartSum = sumOfParts(parts[0]);

        int restSum = 0;
        for (int i = 1; i < parts.length; i++) {
            restSum += sumOfParts(parts[i]);
        }

        return firstPartSum - restSum;
    }

    private static int sumOfParts(String part) {
        String[] numbers = part.split("\\+");
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
