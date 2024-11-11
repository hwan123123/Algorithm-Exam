package sixteam.SSAFY_대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최대 이동 경로의 길이가 50이기에, 이동을 추적하고 미로를 그리는 작업 모두 O(n)의 시간 복잡도가 필요
public class 미로_만들기 {
    // 방향 배열: 북(0), 동(1), 남(2), 서(3)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 이동 경로의 길이
        String moves = br.readLine(); // 이동 경로

        int x = 0, y = 0; // 시작 위치
        int dir = 2; // 초기 방향(남쪽)

        int minX = 0, maxX = 0, minY = 0, maxY = 0;

        // 이동 경로 기록
        boolean[][] visited = new boolean[101][101];
        visited[x + 50][y + 50] = true;

        // 이동 경로를 따라가며 좌표와 방향 변경
        for (int i = 0; i < n; i++) {
            char move = moves.charAt(i);
            if (move == 'L') {
                dir = (dir + 3) % 4; // 왼쪽 회전
            } else if (move == 'R') {
                dir = (dir + 1) % 4; // 오른쪽 회전
            } else if (move == 'F') {
                x += dx[dir];
                y += dy[dir];
                visited[x + 50][y + 50] = true;

                // 이동 경로의 최대/최소 좌표 갱신
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }
        }

        // 미로를 그리기 위해 2차원 배열 생성
        int height = maxX - minX + 1;
        int width = maxY - minY + 1;
        char[][] maze = new char[height][width];

        // 미로의 모든 칸을 벽으로 초기화
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maze[i][j] = '#';
            }
        }

        // 이동 경로에 따라 미로에 빈 칸 표시
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                if (visited[i + 50][j + 50]) {
                    maze[i - minX][j - minY] = '.';
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
