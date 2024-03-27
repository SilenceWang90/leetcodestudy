package com.wp.main.leetcode.medium;

import com.wp.main.common.TreeNode;

/**
 * @author wangpeng
 * @description LeetCode94
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @date 2024/3/27 11:12 AM
 **/
public class LeetCode94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        root.left = left;
        root.right = right;
        TreeNode right_left = new TreeNode(3);
        TreeNode right_right = new TreeNode(6);
        right.left = right_left;
        right.right = right_right;
        System.out.println(individualExecution(root));
    }

    /**
     * 个人思路：递归比较左节点、右节点与根结点的大小是否符合二叉树的要求
     *
     * @param root 根结点
     * @return 是否符合二叉树要求
     */
    public static boolean individualExecution(TreeNode root) {
        return recursion(root);
    }

    private static boolean recursion(TreeNode root) {
        /** 1、递归终止条件 **/
        if (root == null) {
            return true;
        }
        /** 2、递归逻辑 **/
        if (root.left != null & root.right != null) {
            if (root.left.val < root.val && root.val < root.right.val) {
                boolean left = recursion(root.left);
                boolean right = recursion(root.right);
                return left && right;
            } else {
                return false;
            }
        } else if (root.left != null) {
            return root.left.val < root.val;
        } else if (root.right != null) {
            return root.right.val > root.val;
        } else {
            return true;
        }
    }
}
