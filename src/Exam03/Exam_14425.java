package Exam03;

import java.util.HashSet;
import java.util.Scanner;

public class Exam_14425 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        HashSet<String> stringSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            stringSet.add(scanner.next());
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            if (stringSet.contains(scanner.next())) {
                count++;
            }
        }

        System.out.println(count);
    }
}
