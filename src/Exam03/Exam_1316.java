package Exam03;

import java.util.Scanner;

public class Exam_1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        int count = 0;

        for (int i = 0; i < N; i++) {
            String word = sc.nextLine();
            if (wordCount(word)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean wordCount(String word) {
        boolean[] seen = new boolean[26];
        char prevChar = '\0';

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (currentChar != prevChar) {
                if (seen[currentChar - 'a']) {
                    return false;
                }
                seen[currentChar - 'a'] = true;
                prevChar = currentChar;
            }
        }

        return true;
    }
}
