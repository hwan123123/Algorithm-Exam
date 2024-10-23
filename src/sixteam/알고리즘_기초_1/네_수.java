package sixteam.알고리즘_기초_1;

import java.util.Scanner;

public class 네_수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();
        String C = sc.next();
        String D = sc.next();

        long first = Long.parseLong(A + B);
        long second = Long.parseLong(C + D);

        System.out.println(first + second);
    }
}
