package sixteam.알고리즘_기초_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_분석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            int lower = 0;
            int upper = 0;
            int digit = 0;
            int space = 0;

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (Character.isLowerCase(c)) {
                    lower++;
                } else if (Character.isUpperCase(c)) {
                    upper++;
                } else if (Character.isDigit(c)) {
                    digit++;
                } else if (c == ' ') {
                    space++;
                }
            }

            System.out.println(lower + " " + upper + " " + digit + " " + space);
        }
    }
}
