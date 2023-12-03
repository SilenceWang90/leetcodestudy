package com.wp.main.leetcode.medium;

/**
 * @Description 不同的二叉搜索树
 * <p>
 * 给你一个整数n，求恰由n个节点组成且节点值从1到n互不相同的二叉搜索树有多少种？返回满足题意的二叉搜索树的种数。
 * 示例 1：
 * 输入：n = 3
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * <p>
 * 提示：
 * 1 <= n <= 19
 * @Author admin
 * @Date 2023/12/3 12:35
 */
public class LeetCode96_Failure {

    public static Integer result = 0;
    public static Integer total = 0;
    public static Integer nums = 0;

    public static void main(String[] args) {
        System.out.println(individualExecution(3));
        System.out.println(numTrees(3));
//        System.out.println(individualExecution(4));
//        System.out.println(numTrees(4));
//        System.out.println(individualExecution(1));
    }

    /**
     * 个人思路：递归遍历。假设一棵树有3个节点，那么这棵树要想成为二叉搜索树就需要使得：左节点比根节点小，右节点比根节点大。
     * 一棵由n个数字组成的二叉搜索树，任意一棵子树都符合此规律。
     *
     * @param n
     * @return
     */
    private static int individualExecution(int n) {
        total = n;
        nums = n;
        recursion(1, n, total);
        return result;
    }

    /**
     * @param start 起始位置
     * @param end   终止位置
     */
    private static void recursion(int start, int end, int total) {
        /** 1、递归终止条件：节点遍历完成 **/
        if (start > end) {
            return;
        }
        /** 2、递归逻辑 **/
        for (int i = start; i <= end; i++) {
            // 当前选中一个节点，剩下的数字个数为total
            total--;
            // 左子树
            recursion(start, i - 1, total);
            // 右子树
            recursion(i + 1, end, total);
            if (total == 0) {
                // 如果所有节点均已遍历完成，则当前树为一棵二叉搜索树
                result++;
                // 生成一棵树后，计数还原，用于下一次遍历
                total++;
            }
        }
    }

    /**
     * 官方解法：至少在创建左子树和右子树这个思想上是正确的！
     * 动态规划：设定一维数组，该数组每个索引位置上的值表示n个不同的元素能够组成的二叉搜索树的个数
     * 步骤一：以某一个数字为根节点，那么以该节点为根的二叉搜索树个数是左子树二叉搜索树的个数*右子树二叉搜索树的个数
     * 步骤二：然后将每一个节点在步骤一得到的结果进行累加，就是所有的结果。
     * 其中，当n为0或1的时候能形成的二叉搜索树的数量为1
     *
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int leftNum = dp[j - 1];
                int rightNum = dp[i - j];
                dp[i] += leftNum * rightNum;
            }
        }
        return dp[n];
    }

}
