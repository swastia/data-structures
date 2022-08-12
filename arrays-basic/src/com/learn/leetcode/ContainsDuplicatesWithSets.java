package com.learn.leetcode;

import java.util.*;

public class ContainsDuplicatesWithSets {

    public static void main(String[] args) {
        int[] input1 = new int[]{1,2,3,5,6,4};
        boolean hasDuplicates = checkForDuplicates(input1);
        System.out.println(hasDuplicates);
    }

    private static boolean checkForDuplicates(int[] input){
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i<input.length; i++){
            // put in hashset
            if(!set.add(input[i])){
                return true;
            }
        }
        return false;
    }
}
