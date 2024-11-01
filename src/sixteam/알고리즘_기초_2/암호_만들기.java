package sixteam.알고리즘_기초_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 문자 집합 C에서 길이 L의 조합을 생성하기에 이항 계수로 표현됨
// 시간 복잡도: O(C! / (L! x (C-L)!)
public class 암호_만들기 {
    static int L, C;
    static char[] chars;
    static char[] password;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = new char[C];
        password = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chars);  // 사전순 정렬
        backtrack(0, 0);
    }

    // 암호 생성용 백트레킹 메소드
    private static void backtrack(int start, int depth) {
        if (depth == L) {
            if (isValid()) {
                System.out.println(new String(password));
            }
            return;
        }

        for (int i = start; i < C; i++) {
            password[depth] = chars[i];
            backtrack(i + 1, depth + 1);
        }
    }

    // 암호 유효성 검사 메소드
    private static boolean isValid() {
        int vowels = 0;
        int consonants = 0;

        for (char c : password) {
            if (isVowel(c)) {
                vowels++;
            } else {
                consonants++;
            }
        }

        return vowels >= 1 && consonants >= 2;
    }

    // 모음 여부 판별용 메소드
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
