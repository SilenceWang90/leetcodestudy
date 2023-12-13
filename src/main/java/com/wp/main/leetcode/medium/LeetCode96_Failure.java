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
//        System.out.println(individualExecution(4));
//        System.out.println(numTrees(4));
//        System.out.println(individualExecution(1));
    }


    /**
     * 官方思路：以任何一个数i作为根节点，能组成的二叉树搜索树的数量为其左子树的数量*右子树的数量，然后对不同i的结果进行累加，就是n个数字能组成的不同二叉树的数量。按照以上思路，通过动态规划的方式即可获取n个数字能组成的二叉树。
     * 动态规划思路整理：任意n个数字，以i为根节点：其左侧数字取值为[1,i-1]，即共有i-1个数字；右侧数字取值范围为[i+1,n]，即共有n-i个数字。
     * i-1和n-i的结果都是小于n的，因此任意第n项的结果可以从前n项中获取。所以遍历所有情况，通过一维数组记录任意n项数字可以构成的二叉树的数量结果即可。第n项的结果是基于前n项的。
     * 重点：构成二叉树搜索树的条件，造成了左子树的数字只能是比根节点小的，右子树的数字只能比根节点大！！！
     *
     * @param n 连续不同的数字个数
     * @return
     */
    private static int standardExecution(int n) {
        // 记录n个数字可以构成的二叉搜索树
        int[] record = new int[n + 1];
        // 边界值
        record[0] = 1;
        record[1] = 1;
        /** 第一层循环：任意数字i能组成的搜索二叉树的数量，边界值0和1已经知道了，因此初始值从2开始 **/
        for (int i = 2; i <= n; i++) {
            /** 第二层循环：当前有i个数字(第一层循环的值)，以任意根节点能组成的搜索二叉树的数量。因此从根节点为1开始直到i **/
            for (int j = 1; j <= i; j++) {
                // 左子树的数量：之前的结果
                int leftNum = record[j - 1];
                // 右子树的数量：之前的结果
                int rightNum = record[i - j];
                record[i] = record[i] + leftNum * rightNum;
            }
        }
        return record[n];
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

}
