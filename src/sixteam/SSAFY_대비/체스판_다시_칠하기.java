package sixteam.SSAFY_대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 체스판을 탐색할 때 (N - 7) x (M - 7)의 시간 복잡도가 필요하며,
// 체스판을 확인할 때 O(64) = O(1)의 시간 복잡도가 필요하기 때문에
// 전체 시간 복잡도는 O((N - 7) x (M - 7)) = O(N x M)
public class 체스판_다시_칠하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }

        System.out.println(countRepaints(board));
    }

    // 8x8 사이즈로 변환하는 데 필요한 최소 칸 수를 반환하는 메소드
    public static int countRepaints(String[] board) {
        int repaint = Integer.MAX_VALUE; // 최소 칠해야하는 칸 수 저장

        for (int i = 0; i <= board.length - 8; i++) {
            for (int j = 0; j <= board[0].length() - 8; j++) {
                int whiteStartCount = 0; // 맨 왼쪽 위가 흰색인 경우 칠해야 하는 칸 수
                int blackStartCount = 0; // 맨 왼쪽 위가 검은색인 경우 칠해야 하는 칸 수

                for (int x = i; x < i + 8; x++) {
                    for (int y = j; y < j + 8; y++) {
                        char whiteStart = (x + y) % 2 == 0 ? 'W' : 'B';
                        char blackStart = (x + y) % 2 == 0 ? 'B' : 'W';

                        // 현재 칸이 흰색 시작 패턴에 맞지 않으면 repaint 필요
                        if (board[x].charAt(y) != whiteStart) {
                            whiteStartCount++;
                        }

                        // 현재 칸이 검은색 시작 패턴에 맞지 않으면 repaint 필요
                        if (board[x].charAt(y) != blackStart) {
                            blackStartCount++;
                        }
                    }
                }
                repaint = Math.min(repaint, Math.min(whiteStartCount, blackStartCount));
            }
        }
        return repaint;
    }
}