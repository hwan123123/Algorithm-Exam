package Exam03;

import java.util.HashMap;
import java.util.Scanner;

public class Exam_17219 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int N = sc.nextInt();
        int M = sc.nextInt();

        HashMap<String, String> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String site = sc.next();
            String password = sc.next();
            hashMap.put(site, password);
        }

        // 출력 값 입력
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String site = sc.next();
            sb.append(hashMap.get(site)).append('\n');
        }

        // 출력
        System.out.print(sb.toString());
    }
}
