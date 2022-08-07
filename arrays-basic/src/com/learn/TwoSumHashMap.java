package com.learn;

import javax.print.attribute.HashDocAttributeSet;
import java.util.HashMap;
import java.util.Map;

public class TwoSumHashMap {

    public static void main(String[] args) {
        int[] inputArray = new int[]{1, 3, 4, 3, 5};
        int target = 7;

        int[] result = twoSum(inputArray, target);

        if (result != null)
            System.out.println("Indexes are: " + result[0] + ", " + result[1]);
    }

    private static int[] twoSum(int[] nums, int target) {

            /*Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement) && map.get(complement) != i) {
                    return new int[] { i, map.get(complement) };
                }
            }
            // In case there is no solution, we'll just return null
            return null;*/

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }
}
