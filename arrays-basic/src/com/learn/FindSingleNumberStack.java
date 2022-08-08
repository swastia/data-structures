package com.learn;

import java.util.Arrays;
import java.util.Stack;

public class FindSingleNumberStack {
    public static void main(String[] args) {
        int[] input = new int[]{1, 0, 1};
        int output = findSingleNumber(input);

        System.out.println("Single Number is: " + output);
    }

    private static int findSingleNumber(int[] nums) {
        // sort the input array and push into stack, if next number is same, pop the previous number
        // return as soon as consecutive different number appears
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            if (stack.empty()) {
                stack.push(nums[i]);
            } else {
                if (stack.peek() == nums[i]) {
                    stack.pop();
                } else {
                    break;
                }
            }
        }
        return stack.peek();
    }
}
