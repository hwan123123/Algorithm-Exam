package sixteam;

import java.util.Scanner;

public class 진법_변환 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int b = sc.nextInt();

        // B진법 수 N을 10진법으로 변환
        int result = convertToDecimal(n, b);

        System.out.println(result);
    }

    private static int convertToDecimal(String n, int base) {
        return Integer.parseInt(n, base);
    }
}
