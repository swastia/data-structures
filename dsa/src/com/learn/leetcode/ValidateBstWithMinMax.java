package com.learn.leetcode;


import com.learn.tree.BinarySearchTree;

public class ValidateBstWithMinMax {

    private TreeNode root;

    ValidateBstWithMinMax(){
        this.root = null;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public boolean isValidBST(TreeNode root) {

        // it's important to use min and max value by converting to long.
        // if 1 is added or subtracted directly to min and max directly, it will change the sign of the numbers
        // i.e.   int max -2147483648
        //        int min 2147483647
        //        long max 2147483648
        //        long min -2147483649
        return validate(root, ((long) Integer.MIN_VALUE) - 1, ((long) Integer.MAX_VALUE)  + 1);
    }

    private boolean validate(TreeNode node, long min, long max){
        if(node == null){
            return true;
        }

        if(node.val >= max || node.val <= min){
            return false;
        }

        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }


}
