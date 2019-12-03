package ru.itis;

public class Bugs {
    private int maxPath;
    private int leftMaxPath;
    private int rightMaxPath;

    public Bugs() {
        this.maxPath = -1;
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
            bugRec(left, yHalf + yOdd - 1, 0);
            bugRec(xHalf, yHalf, 0);
        } else {
            bugRec(left, yHalf, 0);
            bugRec(xHalf, yHalf + yOdd - 1, 0);
        }
        return leftMaxPath + "," + rightMaxPath;
    }

    private void bugRec(int x, int y, int path) {
        int xHalf = x / 2;
        int yHalf = y / 2;
        int xEven = 1 - (x & 1);
        int yOdd = y & 1;
        int left = xHalf - xEven;
        if (y == 0) {
            return;
        }
        if (y == 1) {
            if (path > maxPath) {
                maxPath = path;
                leftMaxPath = left;
                rightMaxPath = xHalf;
            }
            return;
        }
        if (xHalf > left) {
            bugRec(left, yHalf + yOdd - 1, path + 1);
            bugRec(xHalf, yHalf, path + 1);
        } else {
            bugRec(left, yHalf, path + 1);
            bugRec(xHalf, yHalf + yOdd - 1, path + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Bugs().findDistances(13, 1));
        System.out.println(new Bugs().findDistances(13, 2));
        System.out.println(new Bugs().findDistances(13, 3));
        System.out.println(new Bugs().findDistances(13, 4));
        System.out.println(new Bugs().findDistances(13, 5));
        System.out.println(new Bugs().findDistances(13, 6));
        System.out.println(new Bugs().findDistances(13, 7));

        System.out.println(new Bugs().findDistances(8, 4));
    }
}
