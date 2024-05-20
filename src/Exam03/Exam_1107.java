package Exam03;

import java.util.*;

public class Exam_1107 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        boolean[] brokenButton = new boolean[10]; // 고장난 버튼 배열

        for (int i = 0; i < M; i++) {
            int button = scanner.nextInt();
            brokenButton[button] = true;
        }

        int result = Math.abs(N - 100); // 현재 채널이 100번이므로 +나 -를 사용하지 않고 이동할 때 눌러야하는 버튼 수

        for (int i = 0; i <= 1000000; i++) {
            int pressButton = numberButton(i, brokenButton); // i번 채널로 이동하기 위해 눌러야하는 버튼 수
            if (pressButton > 0) {
                int press = Math.abs(i - N); // +나 -를 사용하여 이동할 때 눌러야하는 버튼 수
                result = Math.min(result, pressButton + press);
            }
        }

        System.out.println(result);
    }

    // 해당 채널로 이동하기 위해 눌러야하는 버튼 수 계산
    public static int numberButton(int channel, boolean[] brokenButton) {
        if (channel == 0) {
            if (brokenButton[0])  {
                return 0; // 0번 채널이 고장났으면 이동할 수 없음
            }
            else return 1;
        }
        int pressButton = 0;
        while (channel > 0) {
            if (brokenButton[channel % 10]) {
                return 0; // 고장난 버튼이면 이동할 수 없음
            }
            pressButton++;
            channel /= 10;
        }
        return pressButton;
    }
}
