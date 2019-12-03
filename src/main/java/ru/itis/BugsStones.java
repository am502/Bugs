package ru.itis;

public class BugsStones {
    private int maxLevel;
    private int leftMax;
    private int rightMax;

    public BugsStones() {
        this.maxLevel = -1;
    }

    public String findDistances(long x, long y) {
        int xHalf = (int) (x / 2);
        int yHalf = (int) (y / 2);
        int xEven = 1 - (int) (x & 1);
        int yOdd = (int) (y & 1);
        int left = xHalf - xEven;
        if (y == 1) {
            return left + "," + xHalf;
        }
        if (xHalf > left) {
            bugRec(left, yHalf + yOdd - 1, 1);
            bugRec(xHalf, yHalf, 1);
        } else {
            bugRec(left, yHalf, 1);
            bugRec(xHalf, yHalf + yOdd - 1, 1);
        }
        return leftMax + "," + rightMax;
    }

    private void bugRec(int x, int y, int level) {
        int xHalf = x / 2;
        int yHalf = y / 2;
        int xEven = 1 - (x & 1);
        int yOdd = y & 1;
        int left = xHalf - xEven;
        if (y == 0) {
            return;
        }
        if (y == 1) {
            if (level > maxLevel) {
                maxLevel = level;
                leftMax = left;
                rightMax = xHalf;
            }
            return;
        }
        if (xHalf > left) {
            bugRec(left, yHalf + yOdd - 1, level + 1);
            bugRec(xHalf, yHalf, level + 1);
        } else {
            bugRec(left, yHalf, level + 1);
            bugRec(xHalf, yHalf + yOdd - 1, level + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new BugsStones().findDistances(13, 1));
        System.out.println(new BugsStones().findDistances(13, 2));
        System.out.println(new BugsStones().findDistances(13, 3));
        System.out.println(new BugsStones().findDistances(13, 4));
        System.out.println(new BugsStones().findDistances(13, 5));
        System.out.println(new BugsStones().findDistances(13, 6));
        System.out.println(new BugsStones().findDistances(13, 7));

        System.out.println(new BugsStones().findDistances(4000000000L, 3000000));
        System.out.println(new BugsStones().findDistances(3999999999L, 5));

        System.out.println(new BugsStones().findDistances(17, 4));
        System.out.println(new BugsStones().findDistances(17, 5));
        System.out.println(new BugsStones().findDistances(17, 6));
    }
}
