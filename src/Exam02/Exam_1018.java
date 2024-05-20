package Exam02;

import java.util.Scanner;

public class Exam_1018 {

    public static int countRepaints(String[] board) {
        int repaint = Integer.MAX_VALUE;
        for (int i = 0; i <= board.length - 8; i++) {
            for (int j = 0; j <= board[0].length() - 8; j++) {
                int repaintCount = 0;
                for (int x = i; x < i + 8; x++) {
                    for (int y = j; y < j + 8; y++) {
                        char color = (x + y) % 2 == 0 ? 'W' : 'B';
                        if (board[x].charAt(y) != color) {
                            repaintCount++;
                        }
                    }
                }
                repaint = Math.min(repaint, Math.min(repaintCount, 64 - repaintCount));
            }
        }
        return repaint;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        String[] board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = sc.nextLine();
        }

        System.out.println(countRepaints(board));
    }
}