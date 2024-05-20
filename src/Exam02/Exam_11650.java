package Exam02;

import java.util.*;

public class Exam_11650 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points.add(new int[]{x, y});
        }

        // Comparator를 이용하여 정렬
        Collections.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[0] == point2[0]) {
                    return point1[1] - point2[1];
                }
                return point1[0] - point2[0];
            }
        });

        for (int[] point : points) {
            System.out.println(point[0] + " " + point[1]);
        }
    }
}

