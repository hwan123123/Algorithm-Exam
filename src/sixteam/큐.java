package sixteam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());  // 명령의 수 입력
        Queue<Integer> queue = new LinkedList<>();

        int lastElement = -1;  // 마지막으로 큐에 추가된 원소를 저장할 변수 초기화

        for (int i = 0; i < N; i++) {
            String command = br.readLine(); // 명령 입력

            if (command.startsWith("push")) { // 명령어가 push로 시작하는 경우
                int value = Integer.parseInt(command.split(" ")[1]); // push 뒤의 값을 정수로 변환
                queue.offer(value); // 큐에 정수 X를 추가
                lastElement = value; // 마지막 원소를 갱신

            } else if (command.equals("pop")) { // 명령어가 pop인 경우
                if (queue.isEmpty()) { // 큐가 비어 있는지 확인
                    result.append("-1\n"); // 비어 있으면 -1을 추가
                } else {
                    result.append(queue.poll()).append("\n"); // 큐에서 가장 앞의 원소를 제거하고 결과에 추가
                }

            } else if (command.equals("size")) { // 명령어가 size인 경우
                result.append(queue.size()).append("\n"); // 큐의 크기를 결과에 추가

            } else if (command.equals("empty")) { // 명령어가 empty인 경우
                result.append(queue.isEmpty() ? "1\n" : "0\n"); // 큐가 비어 있으면 1, 아니면 0을 추가

            } else if (command.equals("front")) { // 명령어가 front인 경우
                if (queue.isEmpty()) { // 큐가 비어 있는지 확인
                    result.append("-1\n"); // 비어 있으면 -1을 추가
                } else {
                    result.append(queue.peek()).append("\n"); // 큐의 가장 앞의 원소를 결과에 추가
                }

            } else if (command.equals("back")) { // 명령어가 back인 경우
                if (queue.isEmpty()) { // 큐가 비어 있는지 확인
                    result.append("-1\n"); // 비어 있으면 -1을 추가
                } else {
                    result.append(lastElement).append("\n"); // 마지막으로 추가된 원소를 결과에 추가
                }
            }
        }

        System.out.print(result.toString()); // StringBuilder에 저장된 모든 결과를 한꺼번에 출력
    }
}
