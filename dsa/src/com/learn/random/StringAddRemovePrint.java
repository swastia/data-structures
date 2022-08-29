package com.learn.random;

import java.util.ArrayList;

public class StringAddRemovePrint {

    public static void main(String[] args) {

        /*
        * Method reference is used to refer method of functional interface.
        * String is not functional interface
        * */
        var list = new ArrayList<String>();
        list.add("Monday");
        //list.add(String::new);
        list.add("Tuesday");
        list.remove(0);
        System.out.println(list.get(0));
    }
}
