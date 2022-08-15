package com.learn.algorithms;

public class Factorial {

    public static Double factorial(int num){
        if(num == 2){
            return 2d;
        }
        return num * factorial(num-1);
    }

    public static void main(String[] args) {
        Double fc = Factorial.factorial(9);
        System.out.println("Factorial:  " + fc);
    }
}
