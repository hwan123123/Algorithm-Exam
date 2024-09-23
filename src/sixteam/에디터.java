package sixteam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String initial = br.readLine(); // 초기 문자열 입력
        int m = Integer.parseInt(br.readLine()); // 명령어 개수 입력

        Stack<Character> leftstack = new Stack<>(); // 커서 왼쪽
        Stack<Character> rightstack = new Stack<>(); // 커서 오른쪽

        for (char c : initial.toCharArray()) {
            leftstack.push(c); // 초기 문자열 커서 왼쪽에 추가
        }

        for (int i = 0; i < m; i++) {
            String command = br.readLine(); // 명령어 입력
            char cmdType = command.charAt(0); // 명령어 타입 확인

            switch (cmdType) {
                case 'L': // 커서 왼쪽 이동
                    if (!leftstack.isEmpty()) { // 커서 왼쪽이 비어있지 않다면
                        rightstack.push(leftstack.pop()); // 커서 왼쪽의 값을 pop하여 커서 오른쪽으로 추가
                    }
                    break;
                case 'D': // 커서 오른쪽 이동
                    if (!rightstack.isEmpty()) { // 커서 오른쪽이 비어있지 않다면
                        leftstack.push(rightstack.pop()); // 커서 오른쪽의 값을 pop하여 커서 왼쪽으로 추가
                    }
                    break;
                case 'B': // 커서 왼쪽 문자 삭제
                    if (!leftstack.isEmpty()) { // 왼쪽 스택이 비어있지 않다면
                        leftstack.pop(); // 커서 왼쪽의 값을 pop
                    }
                    break;
                case 'P': // 커서 왼쪽 문자 추가
                    char toAdd = command.charAt(2); // 추가할 문자
                    leftstack.push(toAdd); // 커서 왼쪽에 문자 추가
                    break;
            }
        }

        StringBuilder result = new StringBuilder();

        while (!leftstack.isEmpty()) {
            result.append(leftstack.pop());  // 왼쪽 스택의 모든 문자를 결과에 추가
        }
        result.reverse(); // 왼쪽 스택에서 꺼낸 문자는 역순이기 때문에 반전시킴

        while (!rightstack.isEmpty()) {
            result.append(rightstack.pop()); // 오른쪽 스택의 모든 문자를 결과에 추가
        }

        System.out.println(result.toString()); // 결과 출력
    }
}
