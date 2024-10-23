package sixteam.알고리즘_기초_1;

import java.util.Scanner;

public class 진법_변환 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int b = sc.nextInt();

        // B진법 수 N을 10진법으로 변환
        int result = Integer.parseInt(n, b);

        System.out.println(result);
    }
}
