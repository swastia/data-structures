package com.learn.leetcode;

public class ContainerWithMostWater {


    public static void main(String[] args) {
        int[] input = new int[]{1,8,6,2,9,4};

        int maxArea = findMaxAreaContainer(input);

        System.out.println("Max area is : " + maxArea);
    }

    private static int findMaxAreaContainer(int[] input){

        int maxArea = 0;

        if(input.length <= 1){
            return maxArea;
        }


        // take two pointers at beginning and end
        int p1 = 0;
        int p2 = input.length -1;

        while(p1 < p2){
            int maxAreaNew = Math.min(input[p1], input[p2]) * (p2-p1);
            if(maxAreaNew > maxArea){
                maxArea = maxAreaNew;
            }
            if(input[p1] < input[p2]){
                p1++;
            }else{
                p2--;
            }
        }
        return maxArea;
    }
}
