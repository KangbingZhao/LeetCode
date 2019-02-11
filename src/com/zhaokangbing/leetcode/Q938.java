package com.zhaokangbing.leetcode;

public class Q938 {

    public static void main(String[] args) {

    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        if (root.val >=L){
            sum += rangeSumBST(root.left,L,R);
        }

        if(root.val>=L && root.val <=R) {
            sum += root.val;
        }
        if (root.val <= R) {
            sum += rangeSumBST(root.right,L,R);
        }
        return sum;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
