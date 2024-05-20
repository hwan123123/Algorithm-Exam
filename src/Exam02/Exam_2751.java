package Exam02;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exam_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        List<Integer> n = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            n.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(n);

        for (int j : n) {
            bw.write(Integer.toString(j));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
