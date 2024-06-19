package Exam03;

import java.util.*;

public class Exam_1764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        Set<String> unheard = new HashSet<>();
        Set<String> unseen = new HashSet<>();

        for (int i = 0; i < N; i++) {
            unheard.add(sc.nextLine());
        }

        for (int i = 0; i < M; i++) {
            unseen.add(sc.nextLine());
        }

        ArrayList<String> overlap = new ArrayList<>();

        for (String s : unheard) {
            if (unseen.contains(s)) {
                overlap.add(s);
            }
        }

        // ArrayList 객체이기 때문에 Collections를 사용하는 것이 자연스러움
        // Collections.sort()는 List 인터페이스를 구현한 클래스의 객체를 정렬하는 데 사용
        // Arrays.sort()는 배열을 정렬하는 데 사용
        Collections.sort(overlap);

        System.out.println(overlap.size());

        for (String s : overlap) {
            System.out.println(s);
        }
    }
}
