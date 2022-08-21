package com.learn.algorithms.sorting;

import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    public List<Integer> sort(List<Integer> unsortedList){
        //100, 20, 34, 54, 62, 0, 5, 1
        for(int i=0; i < unsortedList.size(); i++ ){
            for(int j=0; j < unsortedList.size()-1; j++){
                int item1 = unsortedList.get(j);
                int item2 = unsortedList.get(j+1);
                if(item1 > item2){
                    unsortedList.set(j, item2);
                    unsortedList.set(j+1, item1);
                }
            }
        }

        return unsortedList;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(bubbleSort.sort(Arrays.asList(100, 20, 34, 54, 62, 0, 5, 1)));
    }
}
