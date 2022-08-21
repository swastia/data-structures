package com.learn.algorithms.sorting;
// Given a number N return the index value of the Fibonacci sequence, where the sequence is:

// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
// the pattern of the sequence is that each value is the sum of the 2 previous values, that means that for N=5 → 2+3

//For example: fibonacciRecursive(6) should return 8

public class FibonacciRecursion {

    public static Integer fibonacci(int n){
        //create the base case return

        System.out.println("n is: " + n);
        if(n < 2){
            return n;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(6));
//        System.out.println(fibonacci(2));
//        System.out.println(fibonacci(8));
//        System.out.println(fibonacci(0));
//        System.out.println(fibonacci(1));
//        System.out.println(fibonacci(5));
//        System.out.println(fibonacci(10));
    }
}
