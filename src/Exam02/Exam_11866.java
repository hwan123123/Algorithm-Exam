package Exam02;

import java.util.*;

public class Exam_11866 {
    public static List<Integer> josephusPermutation(int N, int K) {
        List<Integer> josephus = new ArrayList<>();
        Queue<Integer> people = new LinkedList<>();

        // N명의 사람들을 큐에 추가
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }

        while (!people.isEmpty()) {
            // K번째 사람을 제거하고 josephus 리스트에 추가
            for (int i = 0; i < K - 1; i++) {
                people.add(people.poll());
            }
            josephus.add(people.poll());
        }

        return josephus;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        System.out.print("N과 K를 입력하세요 (공백으로 구분): ");
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        // 요세푸스 순열 구하기
        List<Integer> result = josephusPermutation(N, K);

        // 요세푸스 순열 출력
        System.out.print("<");
        for (int i = 0; i < result.size(); i++) {
            if (i < result.size() - 1) {
                System.out.print(result.get(i) + ", ");
            } else {
                System.out.print(result.get(i));
            }
        }
        System.out.println(">");
    }
}
