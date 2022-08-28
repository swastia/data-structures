package com.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBstWithInorder {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        public boolean isValidBST(TreeNode root) {
            // create inorder traversal list
            // validate inorder list to check the order of elements

            if (root == null) {
                return false;
            }

            List<Integer> inorder = new ArrayList<>();

            dfsInOrderBst(root, inorder);

            // validate bst inorder

            for (int i = 0; i < inorder.size() - 1; i++) {
                if (inorder.get(i) >= inorder.get(i + 1)) {
                    return false;
                }
            }

            return true;
        }

        private List dfsInOrderBst(TreeNode currentRoot, List inorder) {

            if (currentRoot.left != null) {
                dfsInOrderBst(currentRoot.left, inorder);
            }

            inorder.add(currentRoot.val);

            if (currentRoot.right != null) {
                dfsInOrderBst(currentRoot.right, inorder);
            }

            return inorder;
        }


    }
}
