package com.wp.main.leetcode.easy;

import com.google.common.collect.Lists;
import com.wp.main.common.TreeNode;

import java.util.Deque;

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
        /** 初始化树形结构 **/
        TreeNode root = new TreeNode(3);
        TreeNode firstLeftNode = new TreeNode(9);
        TreeNode firstRightNode = new TreeNode(20);
        TreeNode secondLeftNode = new TreeNode(15);
        TreeNode secondRightNode = new TreeNode(7);
        root.setLeft(firstLeftNode);
        root.setRight(firstRightNode);
        firstRightNode.setLeft(secondLeftNode);
        firstRightNode.setRight(secondRightNode);
        /** 深度遍历 **/
        System.out.println("深度遍历结果：" + DFS(root));
        /** 广度遍历 **/
        // 声明一个队列存储每一层的节点
        Deque<TreeNode> queue = Lists.newLinkedList();
        // 将根节点放入队列中
        queue.offer(root);
        // 队列尾部加入元素：queue.offer();
        // 队列头部获取元素：queue.pop();
        System.out.println("广度遍历结果：" + BFS(queue));
    }

    /**
     * 深度优先处理：递归
     *
     * @param root
     * @return
     */
    public static int DFS(TreeNode root) {
        // 递归终止条件：空节点
        if (root == null) {
            return 0;
        }
        // 只要当前节点不为空，则意味着该层有节点，所以无论其左右节点是否存在，其深度必然+1
        int leftDepth = DFS(root.left) + 1;
        int rightDepth = DFS(root.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }

    /**
     * 广度优先处理：队列存储每层节点。
     * 使用for(int i ;;)索引遍历可以实现一个队列即完成每层节点的处理，因为在遍历前就知道当前层有几个节点了
     * ，可以在遍历前就获取集合中节点的数量，防止对原集合操作的时候影响集合的大小，从而导致for循环异常
     *
     * @param queue
     * @return
     */
    public static int BFS(Deque<TreeNode> queue) {
        // 递归终止条件
        if (queue.isEmpty()) {
            return 0;
        }
        // 提前获取队列中节点数量固定循环次数，防止遍历queue时对queue操作，影响for循环。
        int nums = queue.size();
        // 遍历该层所有节点，然后将其子节点都放入队列中
        for (int i = 0; i < nums; i++) {
            TreeNode treeNode = queue.pop();
            // 将该节点的左右节点记录在队列中
            if (treeNode != null && treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode != null && treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }
        // 只要该层有节点不为空，即queue集合不为空，则深度+1
        return BFS(queue) + 1;
    }

    /**
     * 广度优先处理：队列存储每层节点。
     * 如果使用foreach循环遍历每层节点，那么就不能在原集合中使用pop和offer，因为这样会影响队列集合的大小，导致foreach循环的逻辑导致报错
     * 只能再新增一个nextQueue存储下一层的节点。代码如下所示：
     *
     * @param queue
     * @return
     */
//    public static int BFS(Deque<TreeNode> queue) {
//        // 递归终止条件
//        if (queue.isEmpty()) {
//            return 0;
//        }
//        // 创建该层的集合，不能向原集合中插入元素，否则影响foreach循环的逻辑。即本来只有1个元素遍历一次，但是遍历的时候又向集合中插入元素，会导致foreach循环报错！
//        Deque<TreeNode> nextQueue = Lists.newLinkedList();
//        // 遍历该层所有节点，然后将其子节点都放入队列中
//        for (TreeNode treeNode : queue) {
//            // 将该节点的左右节点记录在队列中
//            if (treeNode.left != null) {
//                nextQueue.offer(treeNode.left);
//            }
//            if (treeNode.right != null) {
//                nextQueue.offer(treeNode.right);
//            }
//        }
//        // 只要该层有节点不为空，即queue集合不为空，则深度+1
//        return BFS(nextQueue) + 1;
//    }


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
