package Exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exam_18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] opinions = new int[n];

        // 난이도 의견 입력 받기
        for (int i = 0; i < n; i++) {
            opinions[i] = Integer.parseInt(br.readLine());
        }

        // 의견을 정렬하여 가장 낮은 값과 가장 높은 값의 인덱스 구하기
        Arrays.sort(opinions);
        int startIndex = (int) Math.round(n * 0.15); // 위에서 제외될 인덱스 시작 위치

        // 절사평균 계산
        double sum = 0;
        for (int i = startIndex; i < n - startIndex; i++) {
            sum += opinions[i];
        }
        int result = (int) Math.round(sum / (n - 2 * startIndex));

        // 결과 출력
        System.out.println(result);
    }
}
