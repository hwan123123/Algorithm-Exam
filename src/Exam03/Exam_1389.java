package Exam03;

import java.util.*;

public class Exam_1389 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 유저의 수
        int M = scanner.nextInt(); // 친구 관계의 수

        // 그래프 생성
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 친구 관계 입력 받기
        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] kevinBacon = new int[N + 1]; // 케빈 베이컨 수를 저장할 배열

        // 각 사용자별 케빈 베이컨 수 계산
        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            visited[i] = true;
            int bacon = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int current = queue.poll();
                    kevinBacon[i] += bacon; // 케빈 베이컨 수 누적
                    for (int friend : graph[current]) {
                        if (!visited[friend]) {
                            queue.offer(friend);
                            visited[friend] = true;
                        }
                    }
                }
                bacon++; // 한 단계씩 증가
            }
        }

        // 케빈 베이컨 수가 가장 작은 사람 찾기
        int minKevinBacon = Integer.MAX_VALUE;
        int minKevinBaconPerson = 0;
        for (int i = 1; i <= N; i++) {
            if (kevinBacon[i] < minKevinBacon) {
                minKevinBacon = kevinBacon[i];
                minKevinBaconPerson = i;
            }
        }

        System.out.println(minKevinBaconPerson);
    }
}