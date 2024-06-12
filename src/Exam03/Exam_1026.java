package Exam03;

import java.util.Arrays;
import java.util.Scanner;

public class Exam_1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        // A는 오름차순 정렬
        Arrays.sort(A);
        // B는 일단 오름차순 정렬
        Arrays.sort(B);

        // B를 내림차순으로 재배열
        for (int i = 0; i < N / 2; i++) {
            int temp = B[i];
            B[i] = B[N - 1 - i];
            B[N - 1 - i] = temp;
        }

        // S 값 계산식
        int S = 0;
        for (int i = 0; i < N; i++) {
            S += A[i] * B[i];
        }

        // 결과 출력
        System.out.println(S);
    }
}
