package Exam03;

import java.util.*;

public class Exam_1260 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 정점의 개수
        int M = scanner.nextInt(); // 간선의 개수
        int V = scanner.nextInt(); // 탐색을 시작할 정점의 번호

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (ArrayList<Integer> list : graph) {
            Collections.sort(list);
        }

        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(V);
    }

    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i : graph.get(v)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            for (int i : graph.get(v)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
