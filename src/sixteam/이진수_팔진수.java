package sixteam;

import java.math.BigInteger;
import java.util.Scanner;

public class 이진수_팔진수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.nextLine();
        sc.close();

        // 2진수를 10진수로 변환
        BigInteger decimal = new BigInteger(binary, 2);

        // 10진수를 8진수로 변환
        String octal = decimal.toString(8);

        System.out.println(octal);
    }
}
