package sixteam.알고리즘_기초_1;

import java.util.Scanner;

public class 마이너스이진수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder result = new StringBuilder();

        if (n == 0) {
            System.out.println(0);
            return;
        }

        while (n != 0) {
            int remainder = n % -2;
            n /= -2;

            // 나머지가 음수일 경우 조정
            if (remainder < 0) {
                remainder += 2;
                n += 1;
            }

            result.append(remainder);
        }

        System.out.println(result.reverse());
    }
}
