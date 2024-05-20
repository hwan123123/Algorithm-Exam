package Exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Exam_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 명령의 수 N 입력
        Stack<Integer> stack = new Stack<>(); // 정수를 저장하는 스택 생성

        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" "); // 명령을 공백을 기준으로 나눠서 배열에 저장

            switch (command[0]) { // 명령어에 따라 처리
                case "push":
                    int num = Integer.parseInt(command[1]); // push 명령의 경우 두 번째 요소가 추가될 정수
                    stack.push(num);
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(stack.pop()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(stack.peek()).append("\n");
                    }
                    break;
            }
        }

        System.out.print(sb);
    }
}
