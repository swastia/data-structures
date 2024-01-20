package com.learn.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSort {

    // Merge sort uses divide and conquer - recursion O(nlog n) space - O(n)
    // divide the input in smallest possible size
    public static int[] mergeSort(int[] input) {
        // base case - divide till each list has 1 element
        if (input.length == 1) {
            return input;
        }

        // split in left and right arrays
        int arrLength = input.length;
        int mid = arrLength / 2;

        int[] left = Arrays.copyOfRange(input, 0, mid);
        int[] right = Arrays.copyOfRange(input, mid, arrLength);

        return merge(mergeSort(left), mergeSort(right));
    }

    // merge the sorted lists

    private static int[] merge(int[] left, int[] right) {
        int[] resultArr = new int[left.length + right.length];
        int i = 0;
        int l = 0;
        int r = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                resultArr[i] = left[l];
                l++;
                i++;
            } else {
                resultArr[i] = right[r];
                r++;
                i++;
            }

        }

        //Add remaining elements of left and right arrays to result array
        // get remaining left items
        int[] remainingLeft = Arrays.copyOfRange(left, l, left.length);
        int[] remainingRight = Arrays.copyOfRange(right, r, right.length);

        System.arraycopy(remainingLeft, 0, resultArr, resultArr.length, remainingLeft.length);
        System.arraycopy(remainingRight, 0, resultArr, resultArr.length, remainingRight.length);
        return resultArr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{4, 2, 3, 1, 9, 5})));
    }
}
