package com.wp.main.leetcode.easy;

import com.wp.main.common.TreeNode;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 *
 * @author wangpeng
 * @description LeetCode112
 * @date 2024/11/17 09:47
 **/
public class LeetCode112 {
    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(11);
        node1.left = node3;
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(2);
        node3.left = node4;
        node3.right = node5;
        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(4);
        node2.left = node6;
        node2.right = node7;
        TreeNode node8 = new TreeNode(1);
        node7.right = node8;
        System.out.println(individualExecution(root, root.val, 22));*/
        /*TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        System.out.println(individualExecution(root, 0, 5));*/
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        root.left = node1;
        System.out.println(individualExecution(root, 0, 1));
    }

    /**
     * 个人思路：递归，每次递归传递一个根节点，以及当前累计和。
     * 判断当前是否是根节点，如果不是根节点但是和已经大于等于目标和，可以直接返回false；否则递归左右节点，如果有一个返回true则返回true
     * 否则
     *
     * @param root      当前根节点
     * @param current   当前累计和
     * @param targetSum 目标综合
     * @return 是否满足累计和等于目标和
     */
    public static boolean individualExecution(TreeNode root, int current, int targetSum) {
        if (root == null) {
            return false;
        }
        current += root.val;
        if (root.left == null && root.right == null) {
            return current == targetSum;
        } else {
            return individualExecution(root.left, current, targetSum)
                    || individualExecution(root.right, current, targetSum);
        }
    }
}
