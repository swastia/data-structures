package com.learn;

import java.util.Arrays;

public class FindSingleNumberArrays {

    public static void main(String[] args) {
        int[] input = new int[]{1, 0, 0,2,3,2,3,4,5,7,6,4,5,7,6};
        int output = findSingleNumber(input);

        System.out.println("Single Number is: " + output);
    }

    private static int findSingleNumber(int[] nums) {
        // sort the input array and push into stack, if next number is same, pop the previous number
        // return as soon as consecutive different number appears
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int number = 0;

        while (i != j) {
            if (nums[i] == nums[j]) {
                i = j + 1;
                j = nums.length - 1;
            } else
                j--;
        }
        if (i == j) {
            number = nums[j];
        }
        return number;
    }
}

