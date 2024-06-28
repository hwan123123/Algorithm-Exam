package Exam03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam_1158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        List<Integer> result = josephus(N, K);

        System.out.print("<");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(">");
    }

    private static List<Integer> josephus(int N, int K) {
        List<Integer> people = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }

        List<Integer> result = new ArrayList<>();
        int index = 0;

        while (!people.isEmpty()) {
            index = (index + K - 1) % people.size();
            result.add(people.remove(index));
        }

        return result;
    }
}
