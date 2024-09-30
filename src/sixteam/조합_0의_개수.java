package sixteam;

import java.util.Scanner;

public class 조합_0의_개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long m = sc.nextLong();

        // 2와 5의 인수 개수를 구하고 그 중 작은 값을 끝자리 0의 개수로 출력
        long countTwo = countFactors(n, 2) - countFactors(m, 2) - countFactors(n - m, 2);
        long countFive = countFactors(n, 5) - countFactors(m, 5) - countFactors(n - m, 5);

        System.out.println(Math.min(countTwo, countFive));
    }

    // 팩토리얼에서 특정 소수 p의 인수 개수를 구하는 함수
    public static long countFactors(long num, int p) {
        long count = 0;
        while (num >= p) {
            count += num / p;
            num /= p;
        }
        return count;
    }
}
