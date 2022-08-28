package com.learn.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBST {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
         TreeNode left;
         TreeNode right;
         int val;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();

            queue.add(root);

            while(queue.size() >0){

                TreeNode current = queue.poll();
                if(current == null) {
                    return false;
                }
                if(current.left != null){
                    if(current.left.val >= current.val){
                        return false;
                    }
                    queue.add(current.left);
                }
                if(current.right != null){
                    if(current.right.val <= current.val){
                        return false;
                    }
                    queue.add(current.right);
                }
            }
            return true;
        }

    }

    public static void main(String[] args) {

    }
}
