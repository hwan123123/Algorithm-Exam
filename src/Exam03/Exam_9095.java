package Exam03;

import java.util.Scanner;

public class Exam_9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int max = 11;

        // n을 1,2,3의 합으로 나타내는 방법의 수 계산
        int[] dp = new int[max + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // i-1, i-2, i-3에서 각각 1,2,3을 더해서 i를 만들 수 있기 때문에
        // 아래와 같은 점화식을 만들 수 있다.
        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        // 출력
        for (int j = 0; j < T; j++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
