package com.zhaokangbing.leetcode;

/**
 * 1. 递归，O(n^2)
 * 2. 非递归，O(n) https://leetcode.com/problems/maximum-binary-tree/discuss/106146/C%2B%2B-O(N)-solution
 */
public class Q654 {
    public static void main(String[] args){
        int[] test = new int[]{3,2,1,6,0,5};
        TreeNode res = new Q654().constructMaximumBinaryTree(test);
        System.out.println(res);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return recursion(nums,0,nums.length);
    }

    private TreeNode recursion(int[] nums,int start,int end) {
        int biggestIndex = findBiggestIndex(nums,start,end);
        if (biggestIndex == -1) return null;
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        TreeNode root = new TreeNode(nums[biggestIndex]);
        root.left = recursion(nums,start,biggestIndex);
        root.right=recursion(nums,biggestIndex+1,end);
        return root;
    }

    private int findBiggestIndex(int[] nums,int start,int end) {
        if (start<0 || end>nums.length || end<=start) {
            return -1;
        }
        int biggestIndex = start;
        for (int i=start;i<end;i++) {
            if (nums[i] > nums[biggestIndex]) {
                biggestIndex = i;
            }
        }
        return biggestIndex;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
