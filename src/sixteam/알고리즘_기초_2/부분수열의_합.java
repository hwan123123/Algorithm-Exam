package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 각 원소를 포함하거나 포함하지 않는 두 가지 선택지가 있기 때문에 2^N개의 부분 수열이 생겨 전체 시간 복잡도는 O(2^N)
public class 부분수열의_합 {
    static int N, S;
    static int[] numbers;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정수의 개수
        S = Integer.parseInt(st.nextToken()); // 목표 합
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        findSubsequences(0, 0);

        // S가 0일 때 공집합 제외
        System.out.println(S == 0 ? count - 1 : count);
    }

    private static void findSubsequences(int index, int sum) {
        if (index == N) { // 모든 원소를 확인한 경우
            if (sum == S) count++; // 부분수열의 합이 S와 같다면 개수 증가
            return;
        }

        // 현재 원소를 포함하는 경우
        findSubsequences(index + 1, sum + numbers[index]);

        // 현재 원소를 포함하지 않는 경우
        findSubsequences(index + 1, sum);
    }
}
