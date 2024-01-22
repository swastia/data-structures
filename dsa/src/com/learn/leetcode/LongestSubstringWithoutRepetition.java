package com.learn.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepetition {

    // TODO : fix +1 chars coming

    public static void main(String[] args) {

        System.out.println(getLongestStrLength("abcbdaac"));
        System.out.println(getLongestStrLength(""));
        System.out.println(getLongestStrLength("a"));
        System.out.println(getLongestStrLength("aa"));
        System.out.println(getLongestStrLength("abcbdaxyzlmn"));
        System.out.println(getLongestStrLength("abcdefghijklmnop"));


    }

    // Using sliding window technique to find the longest substring without repetition
    private static int getLongestStrLength(String inputStr){
        int longestLen = 0;

        if(inputStr.length() <= 1){
            return inputStr.length();
        }
        char[] input = inputStr.toCharArray();

        // initialize both pointers at the beginning
        int pL = 0, pR = 0;
        int currentLen = 0;
        Map<Character, Integer> indexMap = new HashMap<>();

        while(pR < input.length){

            if(indexMap.containsKey(input[pR])){
                // if char exists in the map, but index is less than pL, then consider it in current string
                // else, reset the current string
                if(indexMap.get(input[pR]) >= pL) {
                    // move the left pointer till the first repeating character +1 index
                    pL = indexMap.get(input[pR]) + 1;
                }
                // reset the value of current char in map
                indexMap.put(input[pR], pR);
                    // calculate the length of the string
                    currentLen = (pR - pL) + 1;
                    longestLen = Math.max(currentLen, longestLen);
                pR++;

            }else{
                indexMap.put(input[pR], pR);
                currentLen++;
                pR++;
                longestLen = Math.max(currentLen, longestLen);
            }
        }

        return longestLen;
    }
}
