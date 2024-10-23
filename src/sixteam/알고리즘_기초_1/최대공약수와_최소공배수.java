package sixteam.알고리즘_기초_1;

import java.util.Scanner;

public class 최대공약수와_최소공배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int gcd = gcd(n, m);
        int lcm = lcm(n, m, gcd);

        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static int lcm(int a, int b, int gcd) {
        return a * b / gcd;
    }
}
