package sixteam.알고리즘_기초_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 요세푸스 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder result = new StringBuilder();

        int N = sc.nextInt(); // 사람의 수 N 입력
        int K = sc.nextInt(); // 제거할 사람의 순서 K 입력

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) { // 1부터 N까지의 사람을 큐에 추가
            queue.offer(i);
        }

        result.append("<");

        while (!queue.isEmpty()) { // 큐가 빌 때까지 반복
            for (int i = 0; i < K - 1; i++) { // K-1번 만큼 사람을 큐의 뒤로 보냄
                queue.offer(queue.poll()); // 가장 앞에서부터 1,2번째 사람을 없애고 추가시켜서 뒤로 보냄
            }

            result.append(queue.poll()); // K번째 사람을 제거하고 결과에 추가
            if (!queue.isEmpty()) { // 큐가 비어있지 않은 경우
                result.append(", "); // 다음 사람 추가를 위한 콤마와 공백 추가
            }
        }

        result.append(">");

        System.out.println(result); // 결과 출력
    }
}
