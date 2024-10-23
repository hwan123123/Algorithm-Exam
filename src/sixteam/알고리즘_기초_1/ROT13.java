package sixteam.알고리즘_기초_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ROT13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            // 소문자인 경우 ROT13 변환
            if (ch >= 'a' && ch <= 'z') {
                char rotChar = (char) ((ch - 'a' + 13) % 26 + 'a');
                result.append(rotChar);
            }
            // 대문자인 경우 ROT13 변환
            else if (ch >= 'A' && ch <= 'Z') {
                char rotChar = (char) ((ch - 'A' + 13) % 26 + 'A');
                result.append(rotChar);
            }
            // 알파벳이 아닌 경우 그대로 추가
            else {
                result.append(ch);
            }
        }

        System.out.println(result);
    }
}
