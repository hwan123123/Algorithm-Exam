package sixteam;

import java.util.Scanner;

public class 소수_찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;

        for (int i = 0; i < N; i++) {
            int number = sc.nextInt();
            if (isPrime(number)) {
                count++;
            }
        }

        System.out.println(count);
    }

    // 소수 확인
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false; // 1은 소수 X
        }
        for (int i = 2; i * i <= num; i++) { // 2부터 제곱근까지 나눠서 확인
            if (num % i == 0) {
                return false; // 나누어떨어지면 소수 X
            }
        }
        return true; // 나누어떨어지지 않으면 소수 O
    }
}
