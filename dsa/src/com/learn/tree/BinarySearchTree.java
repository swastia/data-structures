package com.learn.tree;

import com.sun.source.tree.Tree;

import java.util.*;

public class BinarySearchTree {
    private TreeNode root;

    BinarySearchTree(){
        this.root = null;
    }

    private class TreeNode{
        private final int data;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //insert
    public void insert(int data){
        TreeNode newNode = new TreeNode(data);

        if(this.root == null) {
            // then insert first node at the root
            root = newNode;
        } else{
            // compare and find where to insert the new node
            TreeNode currentNode = this.root;
            while(true){
                if(newNode.data > currentNode.data){
                    if(currentNode.right != null){
                        currentNode = currentNode.right;
                    } else{
                        currentNode.right = newNode;
                        break;
                    }
                }else{
                    if(currentNode.left != null){
                        currentNode = currentNode.left;
                    }else{
                        currentNode.left = newNode;
                        break;
                    }

                }
            }

        }
    }

    // Add a lookup method to find an element

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);


        System.out.println("Printing tree from root:  " + bst.root.data);
        bst.printLeafNodes(bst.root);

        bst.breadthFirstTraversal();

        System.out.println("DST In order list: " + bst.depthFirstTraversal(bst.root, new ArrayList<>()));

    }

    private void printLeafNodes(TreeNode node){
        if(node ==  null){
            return;
        }
        if(node.left == null && node.right == null){
            System.out.println("Leaf node " + node.data);
        }

        if(node.left != null){
            System.out.println("Left node: " + node.left.data);
            printLeafNodes(node.left);
        }

        if(node.right != null){
            System.out.println("Right node: " + node.right.data);
            printLeafNodes(node.right);
        }

    }

    private void breadthFirstTraversal(){
        TreeNode currentNode = this.root;
        List<Integer> allNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(currentNode);

        while(queue.size() > 0){
            currentNode = queue.poll();
            allNodes.add(currentNode.data);
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }
            if(currentNode.right != null){
                queue.add(currentNode.right);
            }
        }
        System.out.println(allNodes);

    }


    // write DFS to traverse through the tree
    // DFS can be done in 3 ways - Inorder, Preorder and postorder
    // DFS is usually implemented using recursion

    private List<Integer> depthFirstTraversal(TreeNode node, List<Integer> allNodes){
        System.out.println("current node: " + node.data);
        System.out.println("current list items: " + allNodes);

        if(node.left != null){
            depthFirstTraversal(node.left, allNodes);
        }
        allNodes.add(node.data);

        if(node.right != null){
            depthFirstTraversal(node.right, allNodes);
        }
        return allNodes;
    }
}
