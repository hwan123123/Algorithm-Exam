package sixteam;

import java.util.Scanner;

public class 단어_뒤집기_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        boolean inTag = false;

        for (char c : input.toCharArray()) {
            if (c == '<') {
                inTag = true; // 태그 안에 있는 경우 boolean 값을 true로 변경
                result.append(word.reverse()); // 현재까지 쌓인 단어를 뒤집어서 결과에 추가
                word.setLength(0); // 단어 저장용 word 객체 초기화
                result.append(c); // '<'를 결과에 추가
            } else if (c == '>') { // '>'를 만나면 태그의 끝
                inTag = false; // 태그 밖으로 나온 경우 boolean 값을 false로 변경
                result.append(c); // '>'를 결과에 추가
            } else if (inTag) { // 태그 안에 있는 경우
                result.append(c); // 태그 안의 문자는 변경 없이 결과에 추가
            } else { // 태그 밖에 있는 경우
                if (c == ' ') { // 공백을 만나면 한 단어가 끝
                    result.append(word.reverse()); // 현재까지 쌓인 단어를 뒤집어서 결과에 추가
                    result.append(c); // 공백을 결과에 추가
                    word.setLength(0); // 단어 저장용 word 객체 초기화
                } else { // 단어의 일부인 경우
                    word.append(c); // 단어를 추가함
                }
            }
        }

        // 마지막 단어가 있을 경우 뒤집어서 결과에 추가
        result.append(word.reverse());

        System.out.println(result); // 결과 출력
    }
}
