package com.learn.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoized {
    int counter1 = 0;
    int counter2 = 0;

    Map<Integer, Long> memo = new HashMap<>();
    private  Long fibonacci(int n){
        counter1++;
        if(n < 2){
            return (long) n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    private Long memoizedFibonacci(int n){
        counter2++;


        if(n < 2){
            return (long) n;
        }

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        long result = memoizedFibonacci(n-1) + memoizedFibonacci(n-2);
        memo.put(n, result);
        return result;

    }

    public static void main(String[] args) {
        FibonacciMemoized memoized = new FibonacciMemoized();
        System.out.println( memoized.fibonacci(7));
        System.out.println(memoized.memoizedFibonacci(7));
        System.out.println("1 " + memoized.counter1);
        System.out.println("2 " + memoized.counter2);
    }
}
