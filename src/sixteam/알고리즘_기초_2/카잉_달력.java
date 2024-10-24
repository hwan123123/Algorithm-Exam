package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// M의 배수들에 대해 N의 조건을 만족하는지를 확인해야 하며,
// 최악의 경우 M x N까지 탐색해야 하기에 시간 복잡도는 O(M x N)
public class 카잉_달력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int result = findYear(M, N, x, y);
            sb.append(result).append("\n");
        }

        System.out.print(sb.toString());
    }

    // 몇 번째 해인지 구하는 메소드
    public static int findYear(int M, int N, int x, int y) {
        x--; // 0-based 계산을 위해 1 감소
        y--;

        for (int k = x; k < (long)M * N; k += M) {
            if (k % N == y) {
                return k + 1; // 1-based로 다시 반환
            }
        }

        return -1; // 찾지 못한 경우
    }
}
