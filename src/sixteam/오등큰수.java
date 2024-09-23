package sixteam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오등큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] result = new int[N];
        HashMap<Integer, Integer> count = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 분리

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            count.put(A[i], count.getOrDefault(A[i], 0) + 1); // 등장 횟수 기록
        }

        // 오등큰수 계산
        for (int i = 0; i < N; i++) {
            // 스택이 비어있지 않고, 현재 숫자의 등장 횟수가 스택에 있는 값보다 큰 경우
            while (!stack.isEmpty() && count.get(A[stack.peek()]) < count.get(A[i])) {
                result[stack.pop()] = A[i]; // 오등큰수로 설정
            }
            stack.push(i); // 현재 값을 스택에 넣음
        }

        // 스택에 남아있는 값은 오등큰수가 없으므로 -1로 설정
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}
