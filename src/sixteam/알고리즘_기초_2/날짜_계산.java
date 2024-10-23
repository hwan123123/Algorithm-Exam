package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최악의 경우 15, 19, 28의 최소 공배수까지 탐색할 수 있기에 시간 복잡도는 O(7980)
public class 날짜_계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int year = 1;
        int e = 1, s = 1, m = 1;

        while (true) {
            if (e == E && s == S && m == M) {
                System.out.println(year);
                break;
            }

            // 연도 증가 및 주기 맞춰서 증가
            year++;
            e++;
            s++;
            m++;

            if (e > 15) {
                e = 1;
            }
            if (s > 28) {
                s = 1;
            }
            if (m > 19) {
                m = 1;
            }
        }
    }
}
