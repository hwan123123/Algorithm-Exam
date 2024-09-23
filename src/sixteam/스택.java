package sixteam;

import java.util.Scanner;
import java.util.Stack;

public class 스택 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int n = sc.nextInt(); // 명령의 수 입력
        sc.nextLine(); // 개행 처리

        StringBuilder sb = new StringBuilder(); // 출력 객체 생성

        for (int i = 0; i < n; i++) {
            String command = sc.nextLine(); // 명령어 입력

            if (command.startsWith("push")) { // 명령어가 push로 시작하는 경우
                int x = Integer.parseInt(command.split(" ")[1]); // push 뒤에 오는 값을 추출
                stack.push(x); // 스택에 정수를 push
            } else if (command.equals("pop")) { // 명령어가 pop인 경우
                if (stack.isEmpty()) { // 스택이 비어 있는지 확인
                    sb.append(-1).append("\n"); // 비어 있다면 -1을 추가
                } else {
                    sb.append(stack.pop()).append("\n"); // 아니면 스택의 최상위 값을 빼고 그 수를 추가
                }
            } else if (command.equals("size")) { // 명령어가 size인 경우
                sb.append(stack.size()).append("\n"); // 스택에 들어있는 정수의 개수를 추가
            } else if (command.equals("empty")) { // 명령어가 empty인 경우
                if (stack.isEmpty()) { // 스택이 비어 있는지 확인
                    sb.append(1).append("\n"); // 비어 있으면 1을 추가
                } else {
                    sb.append(0).append("\n"); // 아니면 0을 추가
                }
            } else if (command.equals("top")) { // 명령어가 top인 경우
                if (stack.isEmpty()) { // 스택이 비어 있는지 확인
                    sb.append(-1).append("\n");  // 비어 있으면 -1을 추가
                } else {
                    sb.append(stack.peek()).append("\n"); // 아니면 스택의 최상위 값을 추가
                }
            }
        }

        System.out.print(sb.toString()); // 결과 출력
    }
}
