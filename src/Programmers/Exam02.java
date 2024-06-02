package Programmers;

public class Exam02 {
    public static int findNextBigNumber(int n) {
        int countOnes = countOnesInBinary(n);

        while (true) {
            n++;
            if (countOnesInBinary(n) == countOnes) {
                return n;
            }
        }
    }

    public static int countOnesInBinary(int number) {
        int count = 0;
        while (number > 0) {
            count += (number & 1);
            number >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 78;
        int answer = findNextBigNumber(n);
        System.out.println(answer);
    }
}
