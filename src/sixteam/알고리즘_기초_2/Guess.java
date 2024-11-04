package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백트래킹을 이용해 탐색할 때 O(21^n)의 시간 복잡도가 필요하며, 부분합의 조건을 확인할 때 O(n^2)의 시간 복잡도가 필요하기에
// 전체 시간 복잡도는 O(21^n x n^2)
public class Guess {
    static int n;
    static char[][] signMatrix;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String signString = br.readLine();

        signMatrix = new char[n][n];
        result = new int[n];

        // signString을 signMatrix로 변환
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                signMatrix[i][j] = signString.charAt(index++);
            }
        }

        if (backtrack(0)) {
            for (int num : result) {
                System.out.print(num + " ");
            }
        }
    }

    static boolean backtrack(int depth) {
        // 모든 숫자를 결정했을 경우
        if (depth == n) {
            return true;
        }

        // 가능한 값 범위: -10부터 10까지
        for (int i = -10; i <= 10; i++) {
            result[depth] = i;
            if (isValid(depth)) {
                if (backtrack(depth + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 현재까지의 부분합이 조건을 만족하는지 확인하는 메소드
    static boolean isValid(int depth) {
        for (int i = 0; i <= depth; i++) {
            int sum = 0;
            for (int j = i; j <= depth; j++) {
                sum += result[j];
                if (signMatrix[i][j] == '+' && sum <= 0) return false;
                if (signMatrix[i][j] == '-' && sum >= 0) return false;
                if (signMatrix[i][j] == '0' && sum != 0) return false;
            }
        }
        return true;
    }
}
