package sixteam.알고리즘_기초_1;

import java.util.Scanner;

public class 최소공배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            // GCD 계산
            int gcd = gcd(A, B);

            // LCM 계산
            long lcm = (long) A * B / gcd;

            sb.append(lcm).append("\n");
        }

        System.out.print(sb);
    }

    // 유클리드 호제법
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
