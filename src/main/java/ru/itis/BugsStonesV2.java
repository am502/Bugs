package ru.itis;

public class BugsStonesV2 {
    private int maxLevel;
    private long leftMax;
    private long rightMax;

    public BugsStonesV2() {
        this.maxLevel = -1;
    }

    public String findDistances(long x, long y) {
        bugRec(x, y, 1);
        return leftMax + "," + rightMax;
    }

    private void bugRec(long x, long y, int level) {
        long xHalf = x / 2;
        long yHalf = y / 2;
        long xEven = 1 - (x & 1);
        long yOdd = y & 1;
        long left = xHalf - xEven;
        if (y == 1) {
            if (level > maxLevel) {
                maxLevel = level;
                leftMax = left;
                rightMax = xHalf;
            }
            return;
        }
        if (yOdd == 1) {
//            bugRec(left, yHalf + yOdd - 1, level + 1);
            bugRec(left, yHalf, level + 1);
        } else {
            bugRec(xHalf, yHalf, level + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new BugsStonesV2().findDistances(13, 1));
        System.out.println(new BugsStonesV2().findDistances(13, 2));
        System.out.println(new BugsStonesV2().findDistances(13, 3));
        System.out.println(new BugsStonesV2().findDistances(13, 4));
        System.out.println(new BugsStonesV2().findDistances(13, 5));
        System.out.println(new BugsStonesV2().findDistances(13, 6));
        System.out.println(new BugsStonesV2().findDistances(13, 7));

        System.out.println(new BugsStonesV2().findDistances(4000000000L, 2000000000L));
        System.out.println(new BugsStonesV2().findDistances(3999999999L, 5));

        System.out.println(new BugsStonesV2().findDistances(17, 4));
        System.out.println(new BugsStonesV2().findDistances(17, 5));
        System.out.println(new BugsStonesV2().findDistances(17, 6));
    }
}
