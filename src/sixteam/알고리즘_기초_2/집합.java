package sixteam.알고리즘_기초_2;

import java.io.*;

// 각 연산은 비트 연산을 사용하여 O(1)로 처리되며, 전체 시간 복잡도는 O(M)
public class 집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int bitmask = 0; // 비트마스크로 집합을 표현하기 위한 변수

        for (int i = 0; i < M; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "add": // x-1번째 비트를 1로 설정 후 집합에 추가
                    int addNum = Integer.parseInt(command[1]) - 1;
                    bitmask |= (1 << addNum);
                    break;
                case "remove": // x-1번째 비트를 0으로 설정 후 집합에서 제거
                    int removeNum = Integer.parseInt(command[1]) - 1;
                    bitmask &= ~(1 << removeNum);
                    break;
                case "check": // x-1번째 비트가 1인지 확인 후 존재 여부 출력
                    int checkNum = Integer.parseInt(command[1]) - 1;
                    int result = (bitmask & (1 << checkNum)) != 0 ? 1 : 0;
                    sb.append(result).append('\n');
                    break;
                case "toggle": // x-1번째 비트를 반전 후 추가/제거를 토글
                    int toggleNum = Integer.parseInt(command[1]) - 1;
                    bitmask ^= (1 << toggleNum);
                    break;
                case "all": // 20개의 모든 비트를 1로 설정 후
                    bitmask = (1 << 20) - 1; // 1부터 20까지 모두 포함된 집합으로 만들기
                    break;
                case "empty":
                    bitmask = 0; // 모든 비트를 0으로 설정하여 공집합으로 초기화
                    break;
            }
        }

        System.out.print(sb);
    }
}
