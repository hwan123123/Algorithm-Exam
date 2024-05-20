package Exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Exam_10773_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                stack.pop(); // 가장 최근에 쓴 수를 지움
            } else {
                stack.push(num); // 0이 아닌 경우 수를 기록
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop(); // 기록된 모든 수의 합 계산
        }

        System.out.println(sum);
    }
}
