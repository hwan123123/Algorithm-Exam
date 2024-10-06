package sixteam;

import java.math.BigInteger;
import java.util.Scanner;

public class 팔진수_이진수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String octal = sc.nextLine();

        // 8진수를 10진수로 변환
        BigInteger decimal = new BigInteger(octal, 8);

        // 10진수를 2진수로 변환
        String binary = decimal.toString(2);

        System.out.println(binary);
    }
}
