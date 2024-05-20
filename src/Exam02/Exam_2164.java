package Exam02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exam_2164 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        // 카드 번호를 큐에 넣기
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        // 카드 버리기 및 밑으로 옮기기 반복
        while (queue.size() > 1) {
            queue.poll(); // 제일 위에 있는 카드 버리기
            int topCard = queue.poll(); // 제일 위에 있는 카드를 저장
            queue.offer(topCard); // 제일 위에 있던 카드를 밑으로 옮기기
        }

        // 마지막에 남은 카드 출력
        System.out.println(queue.peek());
    }
}
