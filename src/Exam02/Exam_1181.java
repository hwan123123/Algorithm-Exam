package Exam02;

import java.util.*;

public class Exam_1181 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        // 중복된 단어를 제거하기 위해 HashSet을 사용합니다.
        Set<String> words = new HashSet<>();

        // N개의 단어를 입력받습니다.
        for (int i = 0; i < N; i++) {
            String word = scanner.nextLine();
            words.add(word);
        }

        // HashSet을 ArrayList으로 변환하여 길이 순으로 정렬합니다.
        List<String> sortedWords = new ArrayList<>(words);
        Collections.sort(sortedWords, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                if (str1.length() == str2.length()) {
                    return str1.compareTo(str2);
                } else {
                    return Integer.compare(str1.length(), str2.length());
                }
            }
        });

        // 정렬된 단어들을 출력합니다.
        for (String word : sortedWords) {
            System.out.println(word);
        }
    }
}