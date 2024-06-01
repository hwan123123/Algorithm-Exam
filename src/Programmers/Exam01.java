package Programmers;

public class Exam01 {
    public int solution(int n) {
        int answer = 0;

        for (int k = 1; k * (k + 1) / 2 <= n; k++) {
            if ((2 * n - k * (k - 1)) % (2 * k) == 0) {
                answer++;
            }
        }
        return answer;
    }
}
