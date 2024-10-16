package sixteam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 이중 반복문을 사용하기 때문에 시간 복잡도는 O(N^2)
public class 가장_긴_증가하는_부분_수열_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N]; // LIS 길이 저장
        int[] prev = new int[N]; // LIS 역추적을 위한 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; // 초기값 1
            prev[i] = -1; // 추적 불가 상태로 초기화
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j; // 이전 인덱스 저장
                }
            }
        }

        // LIS 길이 및 마지막 인덱스 찾기
        int maxLen = 0;
        int lastIndex = 0;
        for (int i = 0; i < N; i++) {
            if (maxLen < dp[i]) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        // 가장 긴 증가하는 부분 수열 추적
        ArrayList<Integer> lis = new ArrayList<>();
        while (lastIndex != -1) {
            lis.add(A[lastIndex]);
            lastIndex = prev[lastIndex];  // 이전 인덱스로 이동
        }

        // LIS는 역순으로 저장되어 있으므로 다시 뒤집어 줍니다.
        Collections.reverse(lis);

        System.out.println(maxLen);  // LIS 길이 출력
        for (int num : lis) {
            System.out.print(num + " ");
        }
    }
}
