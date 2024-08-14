package com.wp.main.leetcode.easy;

import com.wp.main.common.TreeNode;

/**
 * @author wangpeng
 * @description LeetCode104 二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 * <p>
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * @date 2024/3/25 4:24 PM
 **/
public class LeetCode104 {
    public static void main(String[] args) {
    }


    /**
     * 官方解法：最大深度就是当前节点的左右子树深度最大的值然后再+1
     * +1是因为左右子节点到达当前根节点的高度是1
     * @param root
     * @return
     */
    public int standardExecution(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = standardExecution(root.left);
            int rightHeight = standardExecution(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * 个人思路：递归
     *
     * @param treeNode 根结点
     * @return 层数
     */
    public static int individualExecution(TreeNode treeNode) {
        int depth = 0;
        if (treeNode != null) {
            depth = 1;
            depth = recursion(depth, treeNode.left, treeNode.right);
        }
        return depth;
    }

    /**
     * 递归方法
     *
     * @param currentDepth 当前深度
     * @param left         左节点
     * @param right        右节点
     * @return 返回当前可达的深度
     */
    private static int recursion(int currentDepth, TreeNode left, TreeNode right) {
        /** 递归逻辑 **/
        if (left != null && right != null) {
            // 都不为null，则每个子树都去尝试最大深度，最后获取深度最大的值
            currentDepth += 1;
            int leftDepth = recursion(currentDepth, left.left, left.right);
            int rightDepth = recursion(currentDepth, right.left, right.right);
            return Math.max(leftDepth, rightDepth);
        } else if (left != null) {
            // 左子树不为null，右子树尝试获取深度
            currentDepth += 1;
            return recursion(currentDepth, left.left, left.right);
        } else if (right != null) {
            // 右子树不为null，右子树尝试获取深度
            currentDepth += 1;
            return recursion(currentDepth, right.left, right.right);
        } else {
            // 没有子节点，则当前currentDepth就是可达的最大深度
            return currentDepth;
        }
    }
}
