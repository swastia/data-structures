package com.learn;

/*Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1*/


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class FindSingleNumber {
    public static void main(String[] args) {
        int[] input = new int[]{4, 1, 2, 1, 2};

        int output = findSingleNumber(input);

        System.out.println("Single Number is: " + output);
    }

    private static int findSingleNumber(int[] nums) {
        int[] singleNum = new int[1];
        int output = 0;
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i])) {
                numMap.remove(nums[i]);
            } else {
                numMap.put(nums[i], 1);
            }
        }
        // find which key has value 1 in map
        if (numMap.isEmpty()) {
            return output;
        } else if (numMap.values().contains(1) && numMap.size() == 1) {
            // use a biconsumer to find the key
            numMap.entrySet().forEach(entry -> {
                if (entry.getValue() == 1)
                    singleNum[0] = entry.getKey();
            });
        } else {
            return output;
        }
        output = singleNum[0];
        return output;
    }
}
