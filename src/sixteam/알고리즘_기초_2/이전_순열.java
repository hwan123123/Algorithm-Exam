package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 순열 배열을 탐색하는 과정과 스왑, 정렬 모두 배열의 길이 N에 비례하기에 시간 복잡도는 O(N)
public class 이전_순열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (findPermutation(arr)) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
        } else {
            // 첫 번째 순열인 경우 -1 출력
            System.out.println("-1");
        }
    }

    public static boolean findPermutation(int[] arr) {
        int n = arr.length;

        // 뒤에서부터 탐색해서 조건을 만족하는 가장 큰 i 값 찾기
        int i = n - 1;
        while (i > 0 && arr[i - 1] <= arr[i]) {
            i--;
        }

        // i가 0인 경우 첫 번째 순열이기에 false 반환
        if (i == 0) {
            return false;
        }

        // arr[i-1]보다 작은 마지막 값을 찾아 교환할 값인 j 위치 찾기
        int j = n - 1;
        while (arr[i - 1] <= arr[j]) {
            j--;
        }

        swap(arr, i - 1, j);

        // arr[i]부터 끝까지 내림차순으로 정렬 (역순으로 뒤집어버리기)
        reverse(arr, i, n - 1);

        return true;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // 내림차순 정렬
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
