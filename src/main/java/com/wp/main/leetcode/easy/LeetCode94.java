package com.wp.main.leetcode.easy;

import com.google.common.collect.Lists;
import com.wp.main.common.TreeNode;

import java.util.List;

/**
 * @Description 二叉树的中序遍历
 * 给定一个二叉树的根节点root ，返回它的中序遍历。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * @Author wangpeng
 * @Date 2023/11/21 16:41
 */
public class LeetCode94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        root.setRight(right);
        right.setLeft(left);
        System.out.println(individualExecute(root));
        TreeNode root2 = new TreeNode();
        System.out.println(individualExecute(root2));
        TreeNode root3 = new TreeNode(1);
        System.out.println(individualExecute(root3));
    }

    /**
     * 个人思路：递归
     *
     * @param root
     * @return
     */
    private static List<Integer> individualExecute(TreeNode root) {
        // 结果集
        List<Integer> result = Lists.newArrayList();
        // 递归方式
        recursion(root, result);
        return result;
    }

    /**
     * 递归逻辑
     *
     * @param root
     * @param result
     */
    private static void recursion(TreeNode root, List<Integer> result) {
        /**
         * 1、递归终止条件：节点为空
         */
        if (root == null) {
            return;
        }
        /**
         * 2、递归逻辑
         */
        // 递归左节点
        recursion(root.left, result);
        result.add(root.val);
        // 递归右节点
        recursion(root.right, result);
    }
}
