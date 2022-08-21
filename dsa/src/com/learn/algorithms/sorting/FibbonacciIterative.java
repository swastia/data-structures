package com.learn.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class FibbonacciIterative {

    public static int fibbonacci2(int n){
        // create initial index of list, based on these rest of the
        List<Integer> fibbonacciList = new ArrayList<>();
        fibbonacciList.add(0);
        fibbonacciList.add(1);

        for(int i = 2; i< n+1; i++){
            fibbonacciList.add(fibbonacciList.get(i-2) + fibbonacciList.get(i-1));
        }

        return fibbonacciList.get(n);
    }

    public static int fibbonacci1(int n){
        // return the number at n
        int index1= 0;
        int index2 = 1;
        int nextIndex = 0;

        for(int i = 2; i<=n ; i++){
            nextIndex = index1 + index2;
            index1 = index2;
            index2 = nextIndex;
        }
        return nextIndex;
    }

    public static void main(String[] args) {
        System.out.println(fibbonacci2(3));
        System.out.println(fibbonacci2(6));
        System.out.println(fibbonacci2(4));
        System.out.println(fibbonacci2(5));

        System.out.println(fibbonacci1(3));
        System.out.println(fibbonacci1(6));
        System.out.println(fibbonacci1(4));
        System.out.println(fibbonacci1(5));
    }
}
