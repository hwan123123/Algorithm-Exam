package Exam02;

import java.util.*;

public class Exam_10845 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String command = scanner.next();
            switch (command) {
                case "push":
                    int x = scanner.nextInt();
                    queue.offer(x);
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(queue.poll()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(queue.peek()).append("\n");
                    }
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        int last = 0;
                        for (int num : queue) {
                            last = num;
                        }
                        sb.append(last).append("\n");
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
}
