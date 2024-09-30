package sixteam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 골드바흐의_추측 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int MAX = 1000000;
        boolean[] isNotPrime = new boolean[MAX + 1]; // false = 소수

        // 소수 판별
        isNotPrime[0] = isNotPrime[1] = true; // 0,1은 소수 X
        for (int i = 2; i * i <= MAX; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isNotPrime[j] = true;  // i의 배수는 소수 X
                }
            }
        }

        String input;
        while (!(input = br.readLine()).equals("0")) {
            int n = Integer.parseInt(input);
            boolean found = false;

            // n = a + b
            for (int a = 3; a <= n / 2; a += 2) {
                int b = n - a;
                if (!isNotPrime[a] && !isNotPrime[b]) {
                    sb.append(n).append(" = ").append(a).append(" + ").append(b).append("\n");
                    found = true;
                    break;
                }
            }

            if (!found) {
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            }
        }

        System.out.print(sb);
    }
}
