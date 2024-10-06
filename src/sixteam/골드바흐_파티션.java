package sixteam;

import java.util.Scanner;

public class 골드바흐_파티션 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] testCases = new int[T];
        int maxN = 0;
        StringBuilder result = new StringBuilder();

        // 가장 큰 N 구하기
        for (int i = 0; i < T; i++) {
            testCases[i] = sc.nextInt();
            if (testCases[i] > maxN) {
                maxN = testCases[i];
            }
        }

        // 에라토스테네스의 체로 소수 판별
        boolean[] isPrime = new boolean[maxN + 1];
        for (int i = 2; i <= maxN; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= maxN; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxN; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int n : testCases) {
            int partitionCount = 0;

            for (int i = 2; i <= n / 2; i++) {
                if (isPrime[i] && isPrime[n - i]) {
                    partitionCount++;
                }
            }

            result.append(partitionCount).append("\n");
        }

        System.out.print(result);
    }
}
