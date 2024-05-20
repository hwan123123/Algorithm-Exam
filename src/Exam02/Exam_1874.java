package Exam02;

import java.util.Scanner;

public class Exam_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 수열의 길이 입력

        int pushNumber = 1; // 스택에 push할 다음 숫자

        StringBuilder operations = new StringBuilder(); // push와 pop 연산을 저장할 문자열

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt(); // 수열의 원소 입력
            while (pushNumber <= num) {
                // 현재 숫자가 수열의 원소보다 작거나 같으면 해당 숫자까지 push 연산 수행
                operations.append('+'); // push 연산 기록
                operations.append('\n'); // 다음 연산을 위해 개행 추가
                pushNumber++; // 다음 숫자로 넘어감
            }
            // 스택의 맨 위에 있는 숫자를 pop하여 수열의 원소와 일치시킴
            if (!operations.isEmpty() && operations.charAt(operations.length() - 1) == (char)(num + '0')) {
                operations.append('-'); // pop 연산 기록
                operations.append('\n'); // 다음 연산을 위해 개행 추가
                operations.deleteCharAt(operations.length() - 1); // 연산 기록에서 pop 연산 제거
            } else {
                System.out.println("NO");
                return;
            }
        }

        // 모든 수열을 만들었으면 연산 기록 출력
        System.out.println(operations.toString());
    }
}