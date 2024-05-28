package Exam03;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Exam_11279 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x > 0) {
                heap.offer(x);
            } else {
                if (heap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(heap.poll());
                }
            }
        }
    }
}