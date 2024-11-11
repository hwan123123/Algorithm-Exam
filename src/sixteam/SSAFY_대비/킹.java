package sixteam.SSAFY_대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 이동 명령의 최대 개수가 50이므로, 시간 복잡도는 O(N)
public class 킹 {
    // 이동 방향: R, L, B, T, RT, LT, RB, LB 순
    static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static Map<String, Integer> directionMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 방향 초기화
        directionMap.put("R", 0);
        directionMap.put("L", 1);
        directionMap.put("B", 2);
        directionMap.put("T", 3);
        directionMap.put("RT", 4);
        directionMap.put("LT", 5);
        directionMap.put("RB", 6);
        directionMap.put("LB", 7);

        String[] input = br.readLine().split(" ");
        String kingPos = input[0];
        String stonePos = input[1];
        int N = Integer.parseInt(input[2]);

        // 킹과 돌의 초기 위치 설정
        int kingX = kingPos.charAt(1) - '1';
        int kingY = kingPos.charAt(0) - 'A';
        int stoneX = stonePos.charAt(1) - '1';
        int stoneY = stonePos.charAt(0) - 'A';

        // N개의 이동 명령 처리
        for (int i = 0; i < N; i++) {
            String move = br.readLine();
            int direction = directionMap.get(move);

            // 킹의 다음 위치
            int nextKingX = kingX + dx[direction];
            int nextKingY = kingY + dy[direction];

            // 킹의 다음 위치가 체스판 밖이라면 무시
            if (nextKingX < 0 || nextKingX >= 8 || nextKingY < 0 || nextKingY >= 8) {
                continue;
            }

            // 킹의 다음 위치에 돌이 있을 때 돌을 이동
            if (nextKingX == stoneX && nextKingY == stoneY) {
                int nextStoneX = stoneX + dx[direction];
                int nextStoneY = stoneY + dy[direction];

                // 돌이 체스판 밖으로 나가는 경우 무시
                if (nextStoneX < 0 || nextStoneX >= 8 || nextStoneY < 0 || nextStoneY >= 8) {
                    continue;
                }

                // 돌 이동
                stoneX = nextStoneX;
                stoneY = nextStoneY;
            }

            // 킹 이동
            kingX = nextKingX;
            kingY = nextKingY;
        }

        System.out.println((char) (kingY + 'A') + "" + (kingX + 1));
        System.out.println((char) (stoneY + 'A') + "" + (stoneX + 1));
    }
}
