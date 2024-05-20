package Exam02;

import java.io.*;

public class Exam_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++) {
            int sum = i;
            int temp = i;

            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if (sum == N) {
                bw.write(i + " ");
                break;
            }
            if (i == N) {
                bw.write("0");
            }
        }

        bw.flush();
    }
}
