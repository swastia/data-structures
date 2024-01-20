package com.learn.algorithms;

public class Factorial {

    public static Long recursiveFactorial(Long input){

        if(input < 2){
            return 1L;
        }

        return  input * recursiveFactorial(input -1);
    }

    public static void main(String[] args) {
        System.out.println(recursiveFactorial(10L));
    }
}
