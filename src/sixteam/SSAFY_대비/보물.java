package sixteam.SSAFY_대비;

import java.util.Arrays;
import java.util.Scanner;

// 입력: O(N)
// 정렬: O(N log N)
// 내림차순 정렬: O(N)
// 합 계산: O(N)
// 전체 시간 복잡도: O(N log N)
public class 보물 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        // A, B 모두 오름차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        // B를 내림차순으로 재배열
        for (int i = 0; i < N / 2; i++) {
            int temp = B[i];
            B[i] = B[N - 1 - i];
            B[N - 1 - i] = temp;
        }

        int S = 0;
        for (int i = 0; i < N; i++) {
            S += A[i] * B[i];
        }

        System.out.println(S);
    }
}
