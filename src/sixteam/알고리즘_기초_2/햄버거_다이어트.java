package sixteam.알고리즘_기초_2;

import java.util.Scanner;

// 각 재료를 선택하거나 선택하지 않는 두 가지 경우를 고려해야 하기 때문에 최대 2^20개의 부분 집합을 탐색하기에 전체 시간 복잡도는 O(2^N)
public class 햄버거_다이어트 {
    static int maxTaste; // 최대 맛 점수
    static int N, L;
    static int[] tastes, calories;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt(); // 재료의 수
            L = sc.nextInt(); // 칼로리 제한

            tastes = new int[N];
            calories = new int[N];

            // 각 재료의 맛 점수와 칼로리 입력
            for (int i = 0; i < N; i++) {
                tastes[i] = sc.nextInt();
                calories[i] = sc.nextInt();
            }

            maxTaste = 0;
            dfs(0, 0, 0);

            // 결과 출력
            System.out.println("#" + test_case + " " + maxTaste);
        }
        sc.close();
    }

    // 재료 탐색
    private static void dfs(int index, int currentTaste, int currentCalories) {
        // 모든 재료를 탐색한 경우
        if (index == N) {
            if (currentCalories <= L) {
                maxTaste = Math.max(maxTaste, currentTaste); // 최대 맛 점수 갱신
            }
            return;
        }

        // 현재 재료를 포함하지 않는 경우
        dfs(index + 1, currentTaste, currentCalories);

        // 현재 재료를 포함하는 경우 (칼로리 제한 확인)
        if (currentCalories + calories[index] <= L) {
            dfs(index + 1, currentTaste + tastes[index], currentCalories + calories[index]);
        }
    }
}
