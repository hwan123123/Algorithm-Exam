package sixteam.알고리즘_기초_1;

import java.util.Scanner;

public class 소인수분해 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        primeFactorize(n);
    }

    private static void primeFactorize(int n) {
        if (n == 1) {
            return; // N이 1인 경우 출력 없음
        }

        // 2부터 나누어가며 소인수분해
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                System.out.println(i);
                n /= i;
            }
        }

        // 마지막으로 남은 소수
        if (n > 1) {
            System.out.println(n);
        }
    }
}
