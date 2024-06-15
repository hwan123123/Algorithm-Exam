package EtcExam;

import java.io.*;
import java.util.*;

public class SJExam_01 {
    public static void main(String[] args){
        // 상(U), 우(R), 하(D), 좌(L)
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        String moves = "GGGRGGG";
        int n = 0;

//        Map<String, Integer> map = new HashMap<>();
//        map.put("U", 0);
//        map.put("R", 1);
//        map.put("D", 2);
//        map.put("L", 3);

        int[] answer = new int[2];

        for (char s : moves.toCharArray()) {
            if (s == 'G') {
                int nr = answer[0] + dr[n];
                int nc = answer[1] + dc[n];
                if (nr >= 0 && nc >= 0) {
                    answer[0] = nr;
                    answer[1] = nc;
                }
            } else if (s == 'R') {
                n = (n + 1) % 4;
            } else if (s == 'L') {
                n = (n + 3) % 4;
            }
        }

        System.out.println(Arrays.toString(answer));
    }
}
