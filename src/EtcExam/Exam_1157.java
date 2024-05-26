package EtcExam;

import java.util.Scanner;

public class Exam_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next().toUpperCase();
        int[] count = new int[26];

        for (int i = 0; i < input.length(); i++) {
            count[input.charAt(i) - 'A']++;
        }

        int maxCount = 0;
        char mostChar = '?';

        for (int i = 0; i < 26; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                mostChar = (char) (i + 'A');
            } else if (count[i] == maxCount) {
                mostChar = '?';
            }
        }

        System.out.println(mostChar);
    }
}
