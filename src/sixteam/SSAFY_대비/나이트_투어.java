package sixteam.SSAFY_대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

// 입력받은 경로가 36개이므로 전체 시간 복잡도는 O(36) = O(1)
public class 나이트_투어 {
    // 나이트의 이동 방향 정의
    static int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] path = new String[36];

        // 경로 입력
        for (int i = 0; i < 36; i++) {
            path[i] = br.readLine();
        }

        // 시작점과 마지막점의 좌표를 저장
        int startX = path[0].charAt(0) - 'A';
        int startY = path[0].charAt(1) - '1';
        int prevX = startX;
        int prevY = startY;

        // 방문한 위치를 저장하는 HashSet
        HashSet<String> visited = new HashSet<>();
        visited.add(path[0]);

        // 유효성 검사
        boolean isValid = true;
        for (int i = 1; i < 36; i++) {
            int currentX = path[i].charAt(0) - 'A';
            int currentY = path[i].charAt(1) - '1';

            // 나이트의 이동 규칙을 따르는지 확인
            if (!isKnightMove(prevX, prevY, currentX, currentY)) {
                isValid = false;
                break;
            }

            // 중복 방문 체크
            String currentPos = path[i];
            if (visited.contains(currentPos)) {
                isValid = false;
                break;
            }

            // 방문 기록에 추가
            visited.add(currentPos);
            prevX = currentX;
            prevY = currentY;
        }

        // 마지막 위치에서 시작점으로 돌아갈 수 있는지 확인
        if (isValid && !isKnightMove(prevX, prevY, startX, startY)) {
            isValid = false;
        }

        System.out.println(isValid ? "Valid" : "Invalid");
    }

    // 나이트의 이동 규칙을 따르는지 확인하는 메소드
    public static boolean isKnightMove(int x1, int y1, int x2, int y2) {
        for (int i = 0; i < 8; i++) {
            int newX = x1 + dx[i];
            int newY = y1 + dy[i];
            if (newX == x2 && newY == y2) {
                return true;
            }
        }
        return false;
    }
}
