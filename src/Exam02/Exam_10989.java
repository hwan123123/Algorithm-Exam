package Exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[10001]; // 숫자 범위가 1 이상 10,000 이하

        // 숫자의 빈도를 numbers 배열에 저장
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            numbers[num]++;
        }

        // 배열을 정렬
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            for (int j = 0; j < numbers[i]; j++) {
                sb.append(i).append("\n");
            }
        }

        // 최종 결과 출력
        System.out.print(sb);

        br.close();
    }
}
