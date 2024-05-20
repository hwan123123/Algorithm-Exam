package Exam02;

import java.util.*;

public class Exam_2869_3 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();
        int x = (V-B)/(A-B);
        if((V-B)%(A-B) != 0) x++;
        System.out.println(x);
    }
}
