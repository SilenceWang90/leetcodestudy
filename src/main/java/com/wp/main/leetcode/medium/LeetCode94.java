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

    private static boolean recursion(TreeNode currentNode) {
        /** 1、递归终止条件 **/
        if (currentNode == null) {
            return true;
        }
        /** 2、递归逻辑处理 **/
        if (currentNode.left != null && currentNode.left.val >= currentNode.val
                || currentNode.right != null && currentNode.right.val <= currentNode.val) {
            return false;
        } else {
            boolean left = recursion(currentNode.left);
            boolean right = recursion(currentNode.right);
            return left && right;
        }
    }
}
