package com.learn.leetcode;

import com.learn.linkedlist.LinkedList;

public class SinglyLinkedList {

    private Node head;
    private int length;
    private Node tail;

    public SinglyLinkedList(int value) {
        this.head = new Node(value);
        this.tail = this.head;
        length =1;
    }

    public SinglyLinkedList(Node head){
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    class Node{
        // assuming only integer values will be held by this linked list

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void add(int value){
        Node newNode = new Node(value);
        this.tail.next = newNode;
        this.tail = newNode;
        this.length++;
    }

    public static void main(String[] args) {
        // bad way to create a linked list -- use the add method from Linked List class instead

        SinglyLinkedList list = new SinglyLinkedList(10);

        list.add(20);
        list.add(30);
        list.add(40);


        System.out.println(list.toString());

        // reverse the list
        Node newHead = list.reverseLinkedList(list.head);
        list.setHead(newHead);

        System.out.println(list.toString());

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        Node currentNode = this.head;

        while(counter != length){
            sb.append(currentNode.value + " --> ");
            currentNode = currentNode.next;
            counter++;
        }
        return sb.toString();
    }



    private Node reverseLinkedList(Node head){


        if(head == null){
            System.out.println("List is empty");
            return null;
        }
        if(head.next == null){
            System.out.println(head.value);
            return head;
        }

        Node current = head;
        Node next;
        Node prev = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;

    }
}
