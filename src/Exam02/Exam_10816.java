package Exam02;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Exam_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> cardCount = new HashMap<>();

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(str[i]);
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());

        ArrayList<Integer> targets = new ArrayList<>();

        String[] str2 = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(str2[i]);
            targets.add(target);
        }

        // 결과 출력
        for (int target : targets) {
            bw.write(cardCount.getOrDefault(target, 0) + " ");
        }

        bw.flush();
    }
}
