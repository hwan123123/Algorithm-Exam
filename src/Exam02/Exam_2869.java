package Exam02;

import java.util.Scanner;

public class Exam_2869 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int A = scanner.nextInt(); // 달팽이가 하루에 올라가는 거리
        int B = scanner.nextInt(); // 달팽이가 밤에 미끄러지는 거리
        int V = scanner.nextInt(); // 나무의 높이

        int height = 0; // 달팽이의 현재 위치
        int day = 0; // 걸린 날짜

        while (height < V) {
            day++; // 하루가 지남
            height += A; // 하루에 올라가는 거리를 더함

            if (height >= V) {
                break; // 나무 정상에 도달했으면 반복문 종료
            }

            height -= B; // 밤에 내려오는 거리를 뺌
        }

        System.out.println(day); // 결과 출력

        scanner.close();
    }
}
