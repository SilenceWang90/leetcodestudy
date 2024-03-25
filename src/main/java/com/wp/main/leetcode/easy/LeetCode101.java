package com.wp.main.leetcode.easy;

import com.wp.main.common.TreeNode;

/**
 * @author wangpeng
 * @description 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * @date 2024/3/25 1:23 PM
 **/
public class LeetCode101 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(2);
        root.setLeft(left1);
        root.setRight(right1);
        TreeNode left2 = new TreeNode(3);
        TreeNode right2 = new TreeNode(3);
        TreeNode left3 = new TreeNode(4);
        TreeNode right3 = new TreeNode(4);
        left1.setLeft(left2);
        left1.setRight(right3);
        right1.setLeft(left3);
        right1.setRight(right2);
        System.out.println(individualExecution(root));
    }

    /**
     * 个人思路：递归
     *
     * @param root 树根结点
     */
    public static boolean individualExecution(TreeNode root) {
        return symmetry(root.left, root.right);
    }

    public static boolean symmetry(TreeNode leftNode, TreeNode rightNode) {
        /** 1、递归终止条件：判断节点是否相等 **/
        if (leftNode == null && rightNode == null) {
            return true;
        } else if (leftNode != null && rightNode != null && leftNode.val == rightNode.val) {
            /** 2、递归处理逻辑 **/
            //1、 左节点的左节点和右节点的右节点是否相等
            boolean result1 = symmetry(leftNode.left, rightNode.right);
            //2、 左节点的右节点和右节点的左节点是否相等
            boolean result2 = symmetry(leftNode.right, rightNode.left);
            /** 3、递归结束后的处理 **/
            return result1 && result2;
        } else {
            return false;
        }
    }

}
