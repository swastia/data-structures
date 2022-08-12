package com.learn.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
* Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
* */
public class MajorityElement {
    public static void main(String[] args) {
        int[] input = new int[]{3,3,4};
        System.out.println("Majority Element is: " + findMajorityElement(input));
    }

    private static int findMajorityElement(int[] nums){
        int[] nonFinalInt = new int[1];
        Map<Integer, Integer> elementToOccurrenceMap = new HashMap<>();
        for(int i= 0 ; i< nums.length; i++){
            if(elementToOccurrenceMap.containsKey(nums[i])){
                elementToOccurrenceMap.put(nums[i], elementToOccurrenceMap.get(nums[i]) + 1);
            }else{
                elementToOccurrenceMap.put(nums[i], 1);
            }
        }

        // find element whose key is greater than length/2
        elementToOccurrenceMap.entrySet().forEach(entry ->
        {
            if(entry.getValue() > nums.length/2){
                nonFinalInt[0] = entry.getKey();
            }
        });
        return nonFinalInt[0];
    }
}
