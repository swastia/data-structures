package com.learn.algorithms.sorting;

import java.util.Arrays;
import java.util.List;

public class SelectionSort {

    public List<Integer> sort(List<Integer> unsortedList){
        for(int i=0; i<unsortedList.size(); i++){
            int smallest = i;
            int currentItem = unsortedList.get(i);
            for(int j=i+1; j < unsortedList.size(); j++){
                if(unsortedList.get(smallest) > unsortedList.get(j)){
                    smallest = j;
                }
            }
            unsortedList.set(i, unsortedList.get(smallest));
            unsortedList.set(smallest, currentItem);
        }
        return unsortedList;
    }

    public static void main(String[] args) {
        SelectionSort selection = new SelectionSort();
        System.out.println(selection.sort(Arrays.asList(100, 20, 200, 3, 8, 34, 54, 62, 0, 5, 1)));
    }
}
