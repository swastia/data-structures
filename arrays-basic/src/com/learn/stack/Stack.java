package com.learn.stack;

import java.util.Arrays;
/**Simple stack implementation using arrays, ignoring minor checks for now**/
public class Stack {
    // Every stack will have
    private final Object[] stackArr;
    private int top;
    //private int length;

    //create a stack object
    public Stack(int size) {
        this.stackArr = new Object[size];
        //this.length = 0;
        this.top = -1;
    }
    // create a peek method to return top most element

    public Object peek() {
        return this.stackArr[top];
    }

    // create a push method to push one element to the top
    public void push(Object value) {
        // Add a new element to the array and increment the pointer top
        stackArr[++top] = value;
        Arrays.stream(stackArr).forEach(System.out::println);
    }

    // create a pop method to remove one element from the top
    public Object pop() {
        Object popElement = stackArr[top];
        top--;
        return popElement;
    }

    public static void main(String[] args) {
        Stack myStack = new Stack(7);
        myStack.push("Hi");
        myStack.push("Hola! Amigo");
        myStack.push("Buenos Diyas");
        myStack.push("Como Estas?");
        myStack.push("Mue Bean");
        myStack.push("Let's try some int inputs");
        myStack.push(12345);
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
    }

}
