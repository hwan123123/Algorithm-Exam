package Exam02;

import java.util.Scanner;

public class Exam_1654 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int K = scanner.nextInt(); // 이미 가지고 있는 랜선의 개수
        int N = scanner.nextInt(); // 필요한 랜선의 개수

        long[] cables = new long[K];
        long maxLength = 0;

        // 이미 가지고 있는 랜선의 길이를 배열에 저장하고 최대 길이를 구합니다.
        for (int i = 0; i < K; i++) {
            cables[i] = scanner.nextLong();
            maxLength = Math.max(maxLength, cables[i]);
        }

        // 이분 탐색을 사용하여 최대 길이를 찾습니다.
        long start = 1;
        long end = maxLength;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;

            // mid 길이로 만들 수 있는 랜선의 개수를 구합니다.
            for (int i = 0; i < K; i++) {
                count += cables[i] / mid;
            }

            // 만들 수 있는 랜선의 개수가 필요한 랜선의 개수보다 많으면 최대 길이를 갱신하고 탐색 범위를 늘립니다.
            if (count >= N) {
                result = mid;
                start = mid + 1;
            } else { // 만들 수 있는 랜선의 개수가 필요한 랜선의 개수보다 적으면 탐색 범위를 줄입니다.
                end = mid - 1;
            }
        }

        System.out.println(result);

        scanner.close();
    }
}
