package sixteam;

import java.util.Scanner;

public class 진법_변환_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        // 10진수 N을 B진법으로 변환
        String result = convertToBase(n, b);

        System.out.println(result);
    }

    private static String convertToBase(int n, int base) {
        StringBuilder result = new StringBuilder();
        char[] digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        // 0인 경우 바로 반환
        if (n == 0) {
            return "0";
        }

        // n을 base로 나누면서 결과 계산
        while (n > 0) {
            int remainder = n % base;
            result.append(digits[remainder]);
            n /= base;
        }

        // 역순으로 저장되었으므로 뒤집어서 반환
        return result.reverse().toString();
    }
}
