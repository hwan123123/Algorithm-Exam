package sixteam.SSAFY_대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연산자 수가 최대 N-1개이기 때문에 시간 복잡도(경우의 수)는 O((N-1)!)
public class 연산자_끼워넣기 {
    static int N; // 숫자 개수
    static int[] numbers; // 숫자 배열
    static int[] operators; // 연산자 배열
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        // 숫자 배열 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 개수 입력
        operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        // 첫 번째 숫자로 초기화 후 두 번째 숫자부터 탐색
        dfs(numbers[0], 1);

        System.out.println(maxResult);
        System.out.println(minResult);
    }

    public static void dfs(int currentResult, int index) {
        // 모든 숫자를 사용한 경우
        if (index == N) {
            maxResult = Math.max(maxResult, currentResult); // 최댓값 갱신
            minResult = Math.min(minResult, currentResult); // 최솟값 갱신
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 남은 연산자가 있는 경우에만 진행
            if (operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0: // 덧셈
                        dfs(currentResult + numbers[index], index + 1);
                        break;
                    case 1: // 뺄셈
                        dfs(currentResult - numbers[index], index + 1);
                        break;
                    case 2: // 곱셈
                        dfs(currentResult * numbers[index], index + 1);
                        break;
                    case 3: // 나눗셈
                        dfs(divide(currentResult, numbers[index]), index + 1);
                        break;
                }

                operators[i]++;
            }
        }
    }

    // 음수 나눗셈 처리용 메소드
    public static int divide(int a, int b) {
        if (a < 0) {
            return -(-a / b); // 음수를 양수로 바꿔 몫을 구한 후 음수로 변환
        } else {
            return a / b; // 양수는 변환하지 않음
        }
    }
}
