package sixteam;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 덱 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        int N = sc.nextInt(); // 명령의 수 N 입력

        for (int i = 0; i < N; i++) {
            String command = sc.next(); // 명령어 입력
            switch (command) {
                case "push_front": // 덱의 앞에 정수를 추가
                    int x = sc.nextInt(); // 추가할 정수 X 입력
                    deque.offerFirst(x); // 덱의 앞에 X 추가
                    break;
                case "push_back": // 덱의 뒤에 정수를 추가
                    x = sc.nextInt(); // 추가할 정수 X 입력
                    deque.offerLast(x); // 덱의 뒤에 X 추가
                    break;
                case "pop_front": // 덱의 가장 앞의 수를 제거 후 출력
                    if (deque.isEmpty()) { // 덱이 비어있는지 확인
                        result.append("-1\n"); // 비어 있으면 -1을 결과에 추가
                    } else {
                        result.append(deque.pollFirst()).append("\n"); // 가장 앞의 수를 제거하고 결과에 추가
                    }
                    break;
                case "pop_back": // 덱의 가장 뒤의 수를 제거 후 출력
                    if (deque.isEmpty()) { // 덱이 비어있는지 확인
                        result.append("-1\n"); // 비어 있으면 -1을 결과에 추가
                    } else {
                        result.append(deque.pollLast()).append("\n"); // 가장 뒤의 수를 제거하고 결과에 추가
                    }
                    break;
                case "size": // 덱의 크기를 출력
                    result.append(deque.size()).append("\n"); // 덱의 크기를 결과에 추가
                    break;
                case "empty": // 덱이 비어있는지 확인
                    result.append(deque.isEmpty() ? "1\n" : "0\n"); // 비어 있으면 1, 아니면 0을 결과에 추가
                    break;
                case "front": // 덱의 가장 앞의 수를 출력
                    if (deque.isEmpty()) { // 덱이 비어있는지 확인
                        result.append("-1\n"); // 비어 있으면 -1을 결과에 추가
                    } else {
                        result.append(deque.peekFirst()).append("\n"); // 가장 앞의 수를 결과에 추가
                    }
                    break;
                case "back": // 덱의 가장 뒤의 수를 출력
                    if (deque.isEmpty()) { // 덱이 비어있는지 확인
                        result.append("-1\n"); // 비어 있으면 -1을 결과에 추가
                    } else {
                        result.append(deque.peekLast()).append("\n"); // 가장 뒤의 수를 결과에 추가
                    }
                    break;
            }
        }

        System.out.print(result); // 결과 출력
    }
}
