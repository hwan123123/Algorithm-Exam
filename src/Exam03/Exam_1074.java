package Exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam_1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(Z(N, r, c));
    }

    public static int Z(int N, int r, int c) {
        if (N == 1) {
            return 2 * r + c;
        }
        int halfSize = (int) Math.pow(2, N - 1);
        if (r < halfSize && c < halfSize) {
            return Z(N - 1, r, c);
        } else if (r < halfSize && c >= halfSize) {
            return halfSize * halfSize + Z(N - 1, r, c - halfSize);
        } else if (r >= halfSize && c < halfSize) {
            return 2 * halfSize * halfSize + Z(N - 1, r - halfSize, c);
        } else {
            return 3 * halfSize * halfSize + Z(N - 1, r - halfSize, c - halfSize);
        }
    }
}
