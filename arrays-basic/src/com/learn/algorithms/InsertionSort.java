package com.learn.algorithms;

import java.util.Arrays;
import java.util.List;

public class InsertionSort {

    public List<Integer> sort(List<Integer> input){
        // we need to compare elements to it's right side elements,
        //and after a swap, compare with it's left side elements to fnd the correct place.

        for(int i=0; i < input.size()-1; i++){
            if(input.get(i) > input.get(i+1)){
                // comparing element to the right
                int temp = input.get(i);
                input.set(i, input.get(i+1));
                input.set(i+1, temp);

                // now compare the newly swapped element to all on its left
                // using a reverse index - ri
                for(int j= i-1, ri=i; j>=0 ; j--, ri--){
                    if(input.get(ri) < input.get(j)){
                        // swap again in left direction
                        int temp2 = input.get(ri);
                        input.set(ri, input.get(j));
                        input.set(j, temp2);
                    }
                }
            }
        }

        return input;
    }

//    public List<Integer> sort2(List<Integer> input){
//        for(int i=1, j=i-1; i < input.size(); i++){
//            int key = input.get(i);
//
//            while(j>=0 && input.get(j) > key){
//                input.set(i, input.get(j));
//                input.set(j, key);
//                j--;
//            }
//        }
//        return input;
//    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        System.out.println(insertionSort.sort(Arrays.asList(20,100,10,8,5,3,2)));
//        System.out.println(insertionSort.sort2(Arrays.asList(20,100,10,8,5,3,2)));
    }
}
