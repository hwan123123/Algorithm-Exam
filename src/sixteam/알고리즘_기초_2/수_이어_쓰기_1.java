package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 각 자리수의 범위는 1, 10, 100, ..., 10^k로 늘어나므로 자리수는 log N에 비례하기에 시간 복잡도는 O(log N)
public class 수_이어_쓰기_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int length = 0;
        int start = 1;
        int digit = 1;

        while (start <= N) {
            int end = start * 10 - 1;

            if (end > N) {
                end = N; // N보다 커지면 범위를 최대 N 까지로 제한시킴
            }

            // (end - start + 1): 해당 자리수에 존재하는 숫자의 개수
            // digit: 해당 자리수의 숫자들이 가지는 자릿수
            // 두 값을 곱해 현재 자리수에서의 전체 자릿수를 더함
            length += (end - start + 1) * digit;
            start *= 10;
            digit++;
        }

        System.out.println(length);
    }
}
