package com.learn.algorithms;

public class ReverseString {
    // reverse using iterations

    public String reverseString1(String str){

        StringBuilder reverseStr = new StringBuilder();
        char[] chArr = str.toCharArray();
        for(int i = str.length()-1 ; i>=0 ; i--){
            reverseStr.append(chArr[i]);
        }

       return reverseStr.toString();

    }

    public static void main(String[] args) {
        ReverseString revStr = new ReverseString();
        System.out.println("reversed: " + revStr.reverseString1("swasti arya"));
    }
}
