package sixteam.알고리즘_기초_2;

import java.util.Arrays;
import java.util.Scanner;

// 손님 도착 시간을 정렬할 때 O(N logN)의 시간 복잡도가 필요하며,
// 붕어빵 제공 여부를 확인할 때 O(N)의 시간 복잡도가 필요하기에
// 전체 시간복잡도는 O(N logN)
public class 진기의_최고급_붕어빵 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt(); // 손님 수
            int M = sc.nextInt(); // 붕어빵을 만드는 데 걸리는 시간
            int K = sc.nextInt(); // M초마다 만들어지는 붕어빵 개수

            int[] arrivalTimes = new int[N];

            for (int i = 0; i < N; i++) {
                arrivalTimes[i] = sc.nextInt();
            }

            // 손님 도착 시간을 오름차순 정렬
            Arrays.sort(arrivalTimes);

            boolean possible = true; // 모든 손님에게 붕어빵을 줄 수 있는지 여부 확인

            for (int i = 0; i < N; i++) {
                // 각 손님의 도착 시간까지 만들어진 붕어빵 수 계산
                int breadAvailable = (arrivalTimes[i] / M) * K;

                // 필요한 붕어빵의 개수는 현재까지 온 손님 수 i + 1
                if (breadAvailable < i + 1) {
                    possible = false;
                    break;
                }
            }

            System.out.println("#" + test_case + " " + (possible ? "Possible" : "Impossible"));
        }
        sc.close();
    }
}
