package Exam02;

import java.util.Arrays;
import java.util.Scanner;

public class Exam_1920 {

    // 이진 탐색 함수
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        Arrays.sort(A); // A 배열 정렬

        int M = scanner.nextInt();
        int[] searchNums = new int[M];
        for (int i = 0; i < M; i++) {
            searchNums[i] = scanner.nextInt();
        }

        // 탐색 및 결과 출력
        for (int i = 0; i < M; i++) {
            System.out.println(binarySearch(A, searchNums[i]));
        }
    }
}
