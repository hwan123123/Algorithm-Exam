package Exam03;

import java.util.Scanner;

public class Exam_2941 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        String[] croatianAlphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        StringBuilder sb = new StringBuilder(word);

        for (String alphabet : croatianAlphabets) {
            int index = sb.indexOf(alphabet);
            while (index != -1) {
                sb.replace(index, index + alphabet.length(), "#");
                index = sb.indexOf(alphabet);
            }
        }

        int count = sb.length();

        System.out.println(count);
    }
}