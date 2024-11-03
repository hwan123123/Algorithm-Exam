package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백트래킹을 이용해 숫자 조합을 생성할 때 O(10!)의 시간 복잡도가 필요하며, 부등호 조건을 확인할 때 O(k)의 시간 복잡도가 필요하기에
// 전체 시간 복잡도는 O(10! x k)
public class 부등호 {
    static int k;
    static char[] operators;
    static boolean[] visited = new boolean[10];
    static String maxResult = "", minResult = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        operators = new char[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            operators[i] = st.nextToken().charAt(0);
        }

        backtrack("", 0);
        System.out.println(maxResult);
        System.out.println(minResult);
    }

    static void backtrack(String current, int index) {
        if (index == k + 1) {
            if (minResult.equals("") || current.compareTo(minResult) < 0) {
                minResult = current;
            }
            if (maxResult.equals("") || current.compareTo(maxResult) > 0) {
                maxResult = current;
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                // 이전 자리와 현재 자리에 대해 부등호 조건을 확인
                if (index == 0 || checkCondition(current.charAt(index - 1) - '0', i, operators[index - 1])) {
                    visited[i] = true;
                    backtrack(current + i, index + 1);
                    visited[i] = false;
                }
            }
        }
    }

    // 부등호 조건 체크용 메소드
    static boolean checkCondition(int prev, int next, char operator) {
        if (operator == '<') return prev < next;
        if (operator == '>') return prev > next;
        return false;
    }
}
