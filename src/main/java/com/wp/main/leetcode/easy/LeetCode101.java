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

    }

    /**
     * 个人思路：递归
     *
     * @param treeNode 树根结点
     */
    public static void individualExecution(TreeNode treeNode) {


    }

    public static boolean symmetry(TreeNode leftNode, TreeNode rightNode) {
        /** 1、递归终止条件：判断节点是否相等 **/

        /** 2、递归处理逻辑 **/
        //1、 左节点的左节点和右节点的右节点是否相等
        boolean result1 = symmetry(leftNode.left, rightNode.right);
        //2、 左节点的右节点和右节点的左节点是否相等
        boolean result2 = symmetry(leftNode.right, rightNode.left);

        /** 3、递归结束后的处理 **/
        return result1 && result2;
    }

}
