package Exam03;

import java.util.*;

public class Exam_1966 {
    static class Document {
        int index;
        int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Queue<Document> queue = new LinkedList<>();
            int[] priorities = new int[n];

            for (int i = 0; i < n; i++) {
                int priority = sc.nextInt();
                queue.offer(new Document(i, priority));
                priorities[i] = priority;
            }

            Arrays.sort(priorities);
            int highestPriorityIndex = n - 1;
            int printCount = 0;

            while (!queue.isEmpty()) {
                Document current = queue.poll();
                if (current.priority == priorities[highestPriorityIndex]) {
                    printCount++;
                    highestPriorityIndex--;
                    if (current.index == m) {
                        System.out.println(printCount);
                        break;
                    }
                } else {
                    queue.offer(current);
                }
            }
        }
    }
}
