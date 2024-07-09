package Exam02;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exam_1269 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        Set<Integer> A = new HashSet<>();
        for (int i = 0; i < m; i++) {
            A.add(sc.nextInt());
        }

        Set<Integer> B = new HashSet<>();
        for (int i = 0; i < n; i++) {
            B.add(sc.nextInt());
        }

        Set<Integer> symmetricDifference = new HashSet<>(A);
        symmetricDifference.addAll(B);

        Set<Integer> intersection = new HashSet<>(A);
        intersection.retainAll(B);

        symmetricDifference.removeAll(intersection);

        System.out.println(symmetricDifference.size());
    }
}
