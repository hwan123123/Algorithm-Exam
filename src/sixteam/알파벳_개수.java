package sixteam;

import java.util.Scanner;

public class 알파벳_개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();

        int[] alphabet = new int[26];

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            alphabet[ch - 'a']++;
        }

        for (int count : alphabet) {
            System.out.print(count + " ");
        }
    }
}
