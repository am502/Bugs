package ru.itis;

public class App {
    public static void main(String[] args) {
        System.out.println(calculateStonesCount(8, 1));
        System.out.println(calculateStonesCount(8, 2));
        System.out.println(calculateStonesCount(8, 3));

        System.out.println(calculateStonesCount(9, 3));
        System.out.println(calculateStonesCount(9, 4));
        System.out.println(calculateStonesCount(9, 5));

        System.out.println(calculateStonesCount(1, 1));
    }

    private static String calculateStonesCount(long x, long y) {
        int xHalf = (int) (x / 2);
        int yHalf = (int) (y / 2);
        int leftCenterDistance = xHalf - (1 - (int) (x & 1));
        if (y == 1) {
            return leftCenterDistance + "," + xHalf;
        }
        int left, right;
        if ((y & 1) == 1) {
            left = leftCenterDistance - yHalf * 2;
            right = 1;
        } else {
            left = 1;
            right = xHalf - yHalf * 2;
        }
        return left + "," + right;
    }
}
