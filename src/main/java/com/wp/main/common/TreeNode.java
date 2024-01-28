package com.wp.main.common;

import lombok.Data;

/**
 * @Description 二叉树定义
 * @Author wangpeng
 * @Date 2023/11/21 16:42
 */
@Data
public class TreeNode {
    public int val;
    public int val2;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
