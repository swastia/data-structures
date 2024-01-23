package com.learn.linkedlist;

public class LinkedList {

    LLNode tail;
    LLNode head;
    int length;

    class LLNode {
        private Object nodeValue;
        private LLNode nextNode;

        public LLNode(Object value){
            this.nodeValue = value;
            this.nextNode = null;
        }

        public void setNextNode(LLNode nextNode) {
            this.nextNode = nextNode;
        }

        public LLNode getNextNode() {
            return nextNode;
        }

        public void setNodeValue(Object nodeValue) {
            this.nodeValue = nodeValue;
        }

        public Object getNodeValue() {
            return nodeValue;
        }
    }

    //append a node
    public void add(Object value){
        LLNode newNode = new LLNode(value);
        this.tail.nextNode = newNode;
        this.tail = newNode;
        this.length++;
    }

    // delete last element of linked list
    public void delete(){
        // remove tail
        // set previous object to null
        LLNode newTailNode = getNodeAtIndex(this.length -2);
        newTailNode.nextNode = null;
        this.length--;
    }

    // delete element at index
    public void delete(int index){
        LLNode leaderNode = getNodeAtIndex(index -1);
        LLNode deleteNode = leaderNode.nextNode;
        leaderNode.nextNode = deleteNode.nextNode;
        this.length--;
    }

    public void add(int index, Object value){
        LLNode newNode = new LLNode(value);

        if(index >= this.length){
            // append
            this.add(value);
        }else{
            LLNode leader = getNodeAtIndex(index -1);
            LLNode trailingNode = leader.nextNode;
            leader.nextNode = newNode;
            newNode.nextNode = trailingNode;
            this.length++;
        }
    }



    private LLNode getNodeAtIndex(int index){
        int counter = 0;
        LLNode currentNode = this.head;
        while(counter != index){
            currentNode = currentNode.nextNode;
            counter++;
        }
        return currentNode;
    }



    // it should have one constructor, that takes one value and creates a single linked list node

    public LinkedList(Object value){
        this.head = new LLNode(value);
        this.tail = this.head;
        this.length = 1;
    }

    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(10);

        myLinkedList.add(20);
        System.out.println(myLinkedList.toString());
        myLinkedList.add(30);

        System.out.println(myLinkedList.length);
        System.out.println(myLinkedList.toString());

        myLinkedList.add(1, 15);
        System.out.println(myLinkedList.toString());

        myLinkedList.add(3, 25);
        System.out.println(myLinkedList.toString());

        // if index is bigger than length - just append the value
        myLinkedList.add(1000, 50);
        System.out.println(myLinkedList.toString());

        myLinkedList.delete();
        System.out.println(myLinkedList.toString());

        myLinkedList.delete(3);
        System.out.println(myLinkedList.toString());

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        LLNode currentNode = this.head;

        while(counter != length){
            sb.append(currentNode.nodeValue + " --> ");
            currentNode = currentNode.nextNode;
            counter++;
        }
        return sb.toString();
    }

}
