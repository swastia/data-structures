package com.learn.stack;

public class StackUsingLinkedList {

    private StackNode top;
    private StackNode bottom;
    private int length;

    public StackUsingLinkedList() {
        this.top = null;
        this.bottom = null;
        this.length = 0;
    }

    // peek()
    public StackNode peek() {
        if(length == 0){
            System.out.println("Stack is empty");
            return null;
        }
        return this.top;
    }

    //push()
    public void push(Object data) {
        StackNode newNode = new StackNode(data);
        if (length == 0) {
            this.top = newNode;
            this.bottom = newNode;
        } else {
            StackNode temp = this.top;
            this.top = newNode;
            this.top.next = temp;
        }
        this.length++;
    }

    //pop()
    public StackNode pop() {
        StackNode poppedNode;
        if (this.top == null) {
            return null;
        }
        if (this.top == this.bottom) {
            this.bottom = null;
        }
        poppedNode = this.top;
        this.top = this.top.next;
        this.length--;
        return poppedNode;
    }


    // a private node class for this stack
    private class StackNode {
        private final Object data;
        private StackNode next;

        public StackNode(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        StackUsingLinkedList myStack = new StackUsingLinkedList();
        myStack.push("Hello");
        myStack.push("This is my stack with linked list implementation");
        myStack.push(123456789);
        myStack.push(12.34);
        System.out.println("Current Top is : " + myStack.peek().data);
        System.out.println("Popping element: " + myStack.pop().data);
        System.out.println("Current Top is : " + myStack.peek().data);
        System.out.println("Popping element: " + myStack.pop().data);
        System.out.println("Current Top is : " + myStack.peek().data);
        System.out.println("Popping element: " + myStack.pop().data);
        System.out.println("Current Top is : " + myStack.peek().data);
        System.out.println("Popping element: " + myStack.pop().data);
    }
}


