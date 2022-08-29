package com.learn.random;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.function.DoubleBinaryOperator;

public class CheckOutput {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);

        System.out.println("int max" + (Integer.MAX_VALUE+1));
        System.out.println("int min" + (Integer.MIN_VALUE-1));

        System.out.println("long max" + (((long)Integer.MAX_VALUE) +1));
        System.out.println("long min" + (((long)Integer.MIN_VALUE) -1));

        //2147483647
        //-2147483648
        //1.7976931348623157E308
        //4.9E-324
        //int max-2147483648
        //int min2147483647
        //long max2147483648
        //long min-2147483649
    }
}
