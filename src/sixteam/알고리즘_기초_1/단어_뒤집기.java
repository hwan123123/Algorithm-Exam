package sixteam.알고리즘_기초_1;

import java.util.Scanner;

public class 단어_뒤집기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스의 개수 입력
        sc.nextLine(); // 개행 처리

        for (int i = 0; i < T; i++) {
            String sentence = sc.nextLine(); // 문장 입력
            String[] words = sentence.split(" "); // 문장을 공백을 기준으로 나눠서 단어로 배열

            StringBuilder result = new StringBuilder(); // 결과 객체 생성

            for (String word : words) {
                StringBuilder reversedWord = new StringBuilder(word); // 단어를 StringBuilder 객체로 생성
                result.append(reversedWord.reverse()).append(" "); // 단어를 뒤집고 결과 객체에 추가
            }

            System.out.println(result.toString().trim()); // 결과 출력
        }
    }
}
