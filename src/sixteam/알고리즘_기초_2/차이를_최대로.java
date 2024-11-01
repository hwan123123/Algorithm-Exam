package sixteam.알고리즘_기초_2;

import java.util.Scanner;

// 각 순열의 절댓값 차이를 환산할 때 O(N), 순열을 생성할 때 O(N!)의 시간 복잡도를 가지기에
// 전체 시간 복잡도는 O(N x N!)
public class 차이를_최대로 {
    static int maxSum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        permute(A, 0);
        System.out.println(maxSum);
    }

    public static void permute(int[] arr, int k) {
        if (k == arr.length) {
            maxSum = Math.max(maxSum, calculateSum(arr));
        } else {
            for (int i = k; i < arr.length; i++) {
                swap(arr, k, i);
                permute(arr, k + 1);
                swap(arr, k, i);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int calculateSum(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            sum += Math.abs(arr[i] - arr[i + 1]);
        }

        return sum;
    }
}
