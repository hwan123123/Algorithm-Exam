package Exam01;

import java.util.Scanner;

public class Exam_10250 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // 테스트 케이스의 수

        for (int i = 0; i < T; i++) {
            int H = scanner.nextInt(); // 호텔의 층 수
            int W = scanner.nextInt(); // 각 층의 방 수
            int N = scanner.nextInt(); // 몇 번째 손님인지

            int floor = N % H; // 층 수 계산
            int room = N / H + 1; // 방 번호 계산

            // 결과 출력
            System.out.println(floor * 100 + room);
        }

        scanner.close();
    }
}