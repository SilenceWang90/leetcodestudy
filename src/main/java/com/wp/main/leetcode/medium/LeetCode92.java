package com.wp.main.leetcode.medium;

import com.wp.main.common.ListNode;

/**
 * @Description 反转列表 II
 * 给你单链表的头指针head和两个整数left和right，其中left <= right。请你反转从位置left到位置right的链表节点，返回反转后的链表。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * 提示：
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * @Author admin
 * @Date 2023/10/22 16:39
 */
public class LeetCode92 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        ListNode result = individualExecution(node1, 2, 4);
        while (result != null) {
            System.out.print(result.getValue() + " ");
            result = result.getNext();
        }
    }

    /**
     * 个人思路：遍历链表，记录left和left的前置节点，从left开始倒置，直到right节点，并记录right的后置节点。
     * 到right节点倒置完成后，left的前置节点指向right节点，left节点指向right的后置节点。
     *
     * @param head  给定队列头指针
     * @param left  左侧位置
     * @param right 右侧位置
     * @return
     */
    private static ListNode individualExecution(ListNode head, int left, int right) {
        // 链表为空或要翻转的部分只有1个节点，直接当前链表即可
        if (head == null || left == right) {
            return head;
        }
        // 记录当前节点的位置，用于判断是否遍历到left节点、right节点
        int n = 1;
        // 设置top节点，链表的总表头，统一链表行为(头部节点具有特殊性)
        ListNode top = new ListNode(-1);
        top.setNext(head);
        // 当前节点
        ListNode current = head;
        // 当前节点的相邻前置节点
        ListNode pre = top;
        // 当前节点的相邻后置节点
        ListNode next;
        // left节点
        ListNode leftNode = null;
        // left前置节点
        ListNode leftPreNode = null;
        // right节点
        ListNode rightNode = null;
        // right后置节点
        ListNode rightNestNode = null;
        // 遍历节点
        while (current != null) {
            if (n < left) {
                // 未到指定翻转区域，继续遍历
                current = current.getNext();
                pre = pre.getNext();
                n++;
            } else if (n == left) {
                // 如果遍历到left节点，标记leftNode和leftPreNode
                leftPreNode = pre;
                leftNode = current;
                current = current.getNext();
                pre = pre.getNext();
                n++;
            } else if (n > left && n <= right) {
                // 翻转
                // 记录下一个待翻转的节点，用于current节点翻转后可以正确顺移~
                next = current.getNext();
                // 当前节点翻转，指向前一个节点
                current.setNext(pre);
                // pre节点后移到当前节点
                pre = current;
                // 当前节点移到下一个节点
                current = next;
                // 当抵达right节点时
                if (n == right) {
                    // 翻转部分已完成，current节点即为最右侧链表的头节点
                    rightNode = pre;
                    rightNestNode = current;
                    // 遍历可以停止了~
                    break;
                }
                n++;
            }
        }
        // 链表重新拼接
        leftPreNode.setNext(rightNode);
        leftNode.setNext(rightNestNode);
        return top.getNext();
    }
}
