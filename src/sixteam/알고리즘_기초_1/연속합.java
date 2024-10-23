package sixteam.알고리즘_기초_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열을 한 번만 순회하면서 최대 부분합을 계산하기에 시간 복잡도는 O(n)
public class 연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int maxSum = A[0]; // 전체 최대 합
        int currentSum = A[0]; // 현재까지의 최대 부분합

        for (int i = 1; i < n; i++) {
            // 현재 위치에서의 부분합 갱신
            currentSum = Math.max(currentSum + A[i], A[i]);
            // 전체 최대 합 갱신
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }
}
