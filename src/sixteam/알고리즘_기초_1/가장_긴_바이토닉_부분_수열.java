package sixteam.알고리즘_기초_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이중 반복문을 사용하기에 시간 복잡도는 O(N^2)
public class 가장_긴_바이토닉_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] lis = new int[N]; // 왼쪽에서 오른쪽으로의 증가하는 부분 수열
        int[] lds = new int[N]; // 오른쪽에서 왼쪽으로의 증가하는 부분 수열

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 왼쪽에서 오른쪽으로 증가하는 부분 수열 계산
        for (int i = 0; i < N; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // 오른쪽에서 왼쪽으로 증가하는 부분 수열 계산
        for (int i = N - 1; i >= 0; i--) {
            lds[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (A[j] < A[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        // 가장 긴 수열 길이 계산
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            maxLength = Math.max(maxLength, lis[i] + lds[i] - 1);
            // -1은 중복해서 계산되기 때문에 빼주는 것
        }

        System.out.println(maxLength);
    }
}
