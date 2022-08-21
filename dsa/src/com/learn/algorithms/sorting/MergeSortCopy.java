package com.learn.algorithms.sorting;

import java.util.Arrays;

public class MergeSortCopy {

    public static void main(String[] args) {
        int[] array = {6, 1, 4, 7, 5, 2, 8, 3, 0};
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    static void sort(int[] input) {
        mergeSort(input, 0, input.length);
    }

    static void mergeSort(int[] input, int start, int length) {
        if (length > 1) {
            int middle = length / 2;
            int right = start + middle;

            System.out.printf(
                    "%s | %s\n",
                    Arrays.toString(Arrays.copyOfRange(input, start, start + middle)),
                    Arrays.toString(Arrays.copyOfRange(input, right, right + length - middle))
            );

            mergeSort(input, start, middle);
            mergeSort(input, right, length - middle);

            merge(input, start, middle, right, length - middle);
        }
    }

    static void merge(int[] input, int left, int leftLength, int right, int rightLength) {
        int i = left;
        int j = right;
        int leftBound = left + leftLength;
        int rightBound = right + rightLength;
        if (input[leftBound - 1] <= input[right]) {
            System.out.printf(
                    "%s :: %s ==> %s\n",
                    Arrays.toString(Arrays.copyOfRange(input, left, leftBound)),
                    Arrays.toString(Arrays.copyOfRange(input, right, rightBound)),
                    Arrays.toString(Arrays.copyOfRange(input, left, rightBound))
            );
            return;
        }
        System.out.printf(
                "%s :: %s ==> ",
                Arrays.toString(Arrays.copyOfRange(input, left, leftBound)),
                Arrays.toString(Arrays.copyOfRange(input, right, rightBound))
        );
        while (i < leftBound && j < rightBound) {
            if (input[i] < input[j]) {
                i++;
            } else {
                shift(input, j, i);
                i++;
                leftBound++;
                j++;
            }
        }
        System.out.printf(
                "%s\n",
                Arrays.toString(Arrays.copyOfRange(input, left, rightBound))
        );
    }

    static void shift(int[] input, int start, int end) {
        if (start == end) return;
        int value = input[start];
        int temp = input[end];
        if (start > end) {
            for (int i = end; i < start; i++) {
                input[i] = value;
                value = temp;
                temp = input[i + 1];
            }
            input[start] = value;
        } else {
            for (int i = end; i > start; i--) {
                input[i] = value;
                value = temp;
                temp = input[i - 1];
            }
            input[start] = value;
        }
    }
}
