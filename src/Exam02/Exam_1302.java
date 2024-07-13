package Exam02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exam_1302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        HashMap<String, Integer> bookMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String title = sc.nextLine();
            bookMap.put(title, bookMap.getOrDefault(title, 0) + 1);
        }

        String bestSellingBook = "";
        int maxSales = 0;

        for (Map.Entry<String, Integer> entry : bookMap.entrySet()) {
            String title = entry.getKey();
            int sales = entry.getValue();

            if (sales > maxSales || (sales == maxSales && title.compareTo(bestSellingBook) < 0)) {
                maxSales = sales;
                bestSellingBook = title;
            }
        }

        System.out.println(bestSellingBook);
    }
}