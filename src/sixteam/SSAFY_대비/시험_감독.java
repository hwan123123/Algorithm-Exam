package sixteam.SSAFY_대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 입력과 필요한 감독관 수 계산 모두 O(N)의 시간 복잡도가 필요하므로 전체 시간 복잡도도 같다.
public class 시험_감독 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 시험장 개수
        int N = Integer.parseInt(br.readLine());

        // 각 시험장의 응시자 수
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // B와 C 값 입력
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long totalSupervisors = 0;

        for (int i = 0; i < N; i++) {
            // 총감독관 1명 배치
            totalSupervisors++;
            int remaining = A[i] - B;

            // 남은 응시자에 대해 부감독관 배치
            if (remaining > 0) {
                totalSupervisors += (remaining + C - 1) / C;
            }
        }

        System.out.println(totalSupervisors);
    }
}
