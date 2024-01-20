package com.learn.tree;

/* Tree to be created
            9
       4         20
     1   6    15    170
* */
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

    public boolean lookup(int value){
        boolean isNodeExist = false;
        if(this.root == null){
            isNodeExist = false;
        } else{
            TreeNode currentNode = this.root;
            while(currentNode != null){
                if(currentNode.data == value){
                    isNodeExist = true;
                    break;
                } else if(currentNode.data > value){
                    currentNode = currentNode.left;
                } else if(currentNode.data < value){
                    currentNode = currentNode.right;
                }
            }
        }
        return isNodeExist;
    }

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

        System.out.println("Is 9 present in tree : " + bst.lookup(9));
        System.out.println("Is 170 present in tree : " + bst.lookup(170));
        System.out.println("Is 1 present in tree : " + bst.lookup(1));
        System.out.println("Is 15 present in tree : " + bst.lookup(15));
        System.out.println("Is 10 present in tree : " + bst.lookup(10));
        System.out.println("Is 9900 present in tree : " + bst.lookup(9900));


        bst.printLeafNodes(bst.root);

        bst.breadthFirstTraversal();



        System.out.println("DST In order list: " + bst.depthFirstTraversal(bst.root, new ArrayList<>()));

        System.out.println("DST in pre order list: " + bst.dfsPreOrderTraversal(bst.root, new ArrayList<>()));

        System.out.println("DST in post order list: " + bst.dfsPostOrderTraversal(bst.root, new ArrayList<>()));
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

    private List<Integer> dfsPreOrderTraversal(TreeNode node, List<Integer> allNodes){

        System.out.println("Current Node: " + node);

        allNodes.add(node.data);

        if(node.left!= null){
            dfsPreOrderTraversal(node.left, allNodes);
        }

        if(node.right != null){
            dfsPreOrderTraversal(node.right, allNodes);
        }

        return allNodes;

    }


    private List<Integer> dfsPostOrderTraversal(TreeNode node, List<Integer> allNodes){

        System.out.println("Current Node: " + node);

        if(node.left!= null){
            dfsPostOrderTraversal(node.left, allNodes);
        }

        if(node.right != null){
            dfsPostOrderTraversal(node.right, allNodes);
        }

        allNodes.add(node.data);

        return allNodes;
    }
}
