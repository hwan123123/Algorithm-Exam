package Exam03;

import java.util.Arrays;
import java.util.Scanner;

public class Exam_11399 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력
        int N = scanner.nextInt();
        int[] times = new int[N];
        for (int i = 0; i < N; i++) {
            times[i] = scanner.nextInt();
        }
        scanner.close();

        // 정렬
        Arrays.sort(times);

        // 최소 시간 계산
        int totalWaitTime = 0;
        int accumulatedTime = 0;

        for (int time : times) {
            accumulatedTime += time;
            totalWaitTime += accumulatedTime;
        }

        // 출력
        System.out.println(totalWaitTime);
    }
}
