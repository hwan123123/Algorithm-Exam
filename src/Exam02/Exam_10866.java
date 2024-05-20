package Exam02;

import java.util.*;

public class Exam_10866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String command = scanner.next();
            switch (command) {
                case "push_front":
                    int x = scanner.nextInt();
                    deque.offerFirst(x);
                    break;
                case "push_back":
                    x = scanner.nextInt();
                    deque.offerLast(x);
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.pollFirst()).append("\n");
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.pollLast()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.peekLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
}
