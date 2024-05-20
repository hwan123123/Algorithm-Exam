package Exam02;

import java.util.Scanner;

class Person {
    int weight;
    int height;
    int rank;

    Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
        this.rank = 1; // 초기 등수를 1로 설정
    }
}

public class Exam_7568 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 전체 사람의 수 입력
        Person[] people = new Person[N]; // 사람들을 저장할 배열 생성

        // 각 사람의 몸무게와 키 입력 받아서 Person 객체 생성
        for (int i = 0; i < N; i++) {
            int weight = scanner.nextInt();
            int height = scanner.nextInt();
            people[i] = new Person(weight, height);
        }

        // 각 사람들의 덩치 등수 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) { // 같은 사람과의 비교는 제외
                    if (people[i].weight < people[j].weight && people[i].height < people[j].height) {
                        people[i].rank++; // 몸무게와 키가 둘 다 큰 경우 등수 증가
                    }
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            System.out.print(people[i].rank + " ");
        }

        scanner.close();
    }
}