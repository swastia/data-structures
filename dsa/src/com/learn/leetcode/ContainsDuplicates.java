package com.learn.leetcode;
/*


  Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.



  Example 1:

  Input: nums = [1,2,3,1]
  Output: true
  Example 2:

  Input: nums = [1,2,3,4]
  Output: false
  Example 3:

  Input: nums = [1,1,1,3,3,4,3,2,4,2]
  Output: true


  Constraints:

  1 <= nums.length <= 105
  -109 <= nums[i] <= 109

  **/
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicates {
    public static void main(String[] args) {
        int[] input1 = new int[]{1,2,3,5};
        boolean hasDuplicates = checkForDuplicates(input1);
        System.out.println(hasDuplicates);
    }

    private static boolean checkForDuplicates(int[] input){
        Map<Integer, Integer> intToOccurrenceMap = new HashMap<>();

        for(int i = 0; i<input.length; i++){
            // put in hashmap
            if(!intToOccurrenceMap.containsKey(input[i])){
                intToOccurrenceMap.put(input[i], 1);
            }else{
                //intToOccurrenceMap.put(input[i], intToOccurrenceMap.get(input[i]) + 1);
                return true;
            }
        }
        return false;
    }
}
