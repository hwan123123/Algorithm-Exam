package sixteam;

import java.util.Scanner;

public class 팩토리얼_0의_개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int zeroCount = 0;

        for (int i = 5; i <= N; i *= 5) {
            zeroCount += N / i;
        }

        System.out.println(zeroCount);
    }
}
