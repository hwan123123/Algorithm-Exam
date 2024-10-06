package sixteam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숨바꼭질_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 동생 위치
        int S = Integer.parseInt(st.nextToken()); // 수빈 위치

        int[] differences = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(st.nextToken());
            differences[i] = Math.abs(A - S);
        }

        int gcdValue = differences[0];
        for (int i = 1; i < N; i++) {
            gcdValue = gcd(gcdValue, differences[i]);
        }

        System.out.println(gcdValue);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
