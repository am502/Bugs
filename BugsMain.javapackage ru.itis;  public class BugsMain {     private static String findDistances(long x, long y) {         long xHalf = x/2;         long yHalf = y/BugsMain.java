package ru.itis;

public class BugsMain {
    private static String findDistances(long x, long y) {
        long xHalf = x / 2;
        long yHalf = y / 2;
        long left = xHalf - 1 + (x & 1);
        if (y == 1) {
            return left + "," + xHalf;
        }
        if ((y & 1) == 1) {
            return findDistances(left, yHalf);
        } else {
            return findDistances(xHalf, yHalf);
        }
    }

    public static void main(String[] args) {
        System.out.println(findDistances(4000000000L, 3999999999L));
    }
}
