/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 **/

// Assuming numbers won't repeat in the input array


package com.learn.leetcode;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {

        int[] input = new int[]{3,2,5, 1,4};
        int target = 7;

        int[] result = twoSum(input, target);

        if (result == null) {
            System.out.println("All numbers are greater than equal to the target, no results for this input");
        } else {
            // print output
            for (int i : result
            ) {
                System.out.println("Index: " + i);
            }
        }

    }

    private static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int[] sortedNums = Arrays.copyOf(nums, nums.length);

        //sort the array
        Arrays.sort(sortedNums);
        int num1 = -1;
        int num2 = -1;

        int pivotIndex = 0;

        if (nums[0] > target) {
            return null;
        }

        int index=0;
        while(index < sortedNums.length){
            //loop through the array to find inputs lesser than target
            if (index == sortedNums.length - 1) {
                // reset pivot and index
                pivotIndex = pivotIndex + 1;
                index = pivotIndex + 1;
                continue;
            } else if (sortedNums[index + 1] <= target) {
                int sumTwo = sortedNums[pivotIndex] + sortedNums[index + 1];
                if (sumTwo == target) {
                    //return these indexes
                    num1 = sortedNums[pivotIndex];
                    num2 = sortedNums[index + 1];
                    break;
                } else if (sumTwo > target) {
                    // there is no such pair possible with this pivot
                    // change the pivot
                    pivotIndex = pivotIndex + 1;
                    index = pivotIndex + 1;
                }
            }
            index++;
        }

        if(num1 != -1 && num2 != -1){
            for(int i = 0; i<nums.length ; i ++){
                if(nums[i] == num1 ) {
                    result[0] = i;
                } else if (nums[i] == num2 ) {
                    result[1] = i;
                }
            }
        }

        return result;
    }


}
