package ru.itis;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    private static List<int[]> permutations = new LinkedList<>();

    public static void main(String[] args) {
        int[] array = arange(3);
        permutations(array, 0);
        permutations.forEach(p -> System.out.println(Arrays.toString(p)));
        System.out.println(permutations.size());
    }

    private static int[] arange(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    private static void permutations(int[] array, int start) {
        if (start == array.length - 1) {
            permutations.add(array);
        }
        for (int i = start; i < array.length; i++) {
            int[] clonedArray = array.clone();
            swap(clonedArray, start, i);
            permutations(clonedArray, start + 1);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
