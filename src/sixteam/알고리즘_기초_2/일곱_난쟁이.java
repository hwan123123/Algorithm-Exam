package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱_난쟁이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] height = new int[9];
        int total = 0;

        for (int i = 0; i < 9; i++) {
            height[i] = Integer.parseInt(br.readLine());
            total += height[i];
        }

        boolean found = false;

        // 두 난쟁이 찾기
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (total - height[i] - height[j] == 100) {
                    height[i] = height[j] = -1; // 두 명을 제외
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        Arrays.sort(height); // 오름차순 정렬

        for (int i = 2; i < 9; i++) { // 제외된 두 명은 -1이 되었으므로 무시
            System.out.println(height[i]);
        }
    }
}
