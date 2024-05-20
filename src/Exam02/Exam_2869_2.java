package Exam02;

import java.io.*;

public class Exam_2869_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = br.readLine().split(" ");
        int A = Integer.parseInt(strs[0]);
        int B = Integer.parseInt(strs[1]);
        int V = Integer.parseInt(strs[2]);

        int height = 0;
        int day = 0;

        while (height < V) {
            day++;
            height += A;

            if (height >= V) {
                break;
            }

            height -= B;
        }

        bw.write(String.valueOf(day));

        br.close();
        bw.close();
    }
}
