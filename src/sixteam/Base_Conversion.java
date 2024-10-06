package sixteam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Base_Conversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int m = sc.nextInt();

        // A진법 숫자 입력
        int[] digits = new int[m];
        for (int i = 0; i < m; i++) {
            digits[i] = sc.nextInt();
        }

        // A진법을 10진법으로 변환
        int decimalValue = convertToDecimal(a, digits);

        // 10진법을 B진법으로 변환
        List<Integer> resultInBaseB = convertFromDecimal(decimalValue, b);

        for (int digit : resultInBaseB) {
            System.out.print(digit + " ");
        }
    }

    private static int convertToDecimal(int base, int[] digits) {
        int result = 0;
        for (int digit : digits) {
            result = result * base + digit;
        }
        return result;
    }

    private static List<Integer> convertFromDecimal(int decimal, int base) {
        List<Integer> result = new ArrayList<>();
        if (decimal == 0) {
            result.add(0);
        } else {
            while (decimal > 0) {
                result.add(0, decimal % base);
                decimal /= base;
            }
        }
        return result;
    }
}
