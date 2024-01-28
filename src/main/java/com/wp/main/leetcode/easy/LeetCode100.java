package com.wp.main.leetcode.easy;

import com.wp.main.common.TreeNode;

/**
 * @Description 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1：
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 * <p>
 * 提示：
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 * @Author admin
 * @Date 2024/1/28 13:37
 */
public class LeetCode100 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode();
        TreeNode q = new TreeNode();
        System.out.println(individualExecution(p, q));
    }

    /**
     * 个人思路：统一按照中序遍历确认每个节点的值是否相同
     *
     * @param p 二叉树p
     * @param q 二叉树q
     * @return p和q是否相同
     */
    private static boolean individualExecution(TreeNode p, TreeNode q) {
        /** 1、节点是否相等判断 **/
        // 两个节点的下一个节点都为空，则null必然等于null，返回true。
        if (p == null && q == null) {
            return true;
        }
        // 两个节点有一个为空，另一个不为空，则两个二叉树不相等
        if (p == null || q == null) {
            return false;
        }

        /*// bbbbb以上代码可以优化为如下：很不错~
        if (p == null || q == null) {
            return p == q;
        }*/

        /** 2、递归逻辑：递归遍历(中序遍历)节点 **/
        // 2.1、左子树是否相同1
        boolean left = individualExecution(p.left, q.left);
        // 2.2、根节点是否相同2
        boolean current = (p.val == q.val);
        // 2.3、右子树是否相同3
        boolean right = individualExecution(p.right, q.right);
        // 返回当前子树是否相同4 5
        return left && right && current;
    }
}
