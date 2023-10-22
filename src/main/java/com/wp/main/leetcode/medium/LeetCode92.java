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
     * 个人思路：遍历链表，将该链表一共拆分为3段，[start,left),[left,right],(right,end]
     * 倒置[left,right]后重新链接3个链表，其中(right,end]不需要遍历完成，只需要记录right-1位置上的节点即可，用于链表拼接
     *
     * @param head  给定队列头指针
     * @param left  左侧位置
     * @param right 右侧位置
     * @return
     */
    private static ListNode individualExecution(ListNode head, int left, int right) {
        // 记录当前节点的位置，用于判断是否和left、right重合
        int n = 1;
        // 设置top节点，链表的总表头，统一链表行为(头部节点具有特殊性)
        ListNode top = new ListNode(-1);
        top.setNext(head);
        // pre为current的前一个节点
        ListNode pre = top;
        // 当前节点
        ListNode current = head;
        // 要倒转链表的头节点
        ListNode leftNode = null;
        // 最后一段链表的头节点
        ListNode rightListNodeHead = null;
        while (current != null) {
            if (n == left) {
                // 当前节点为left时，记录当前节点
                leftNode = current;
            } else if (n == right) {
                // 当前节点为right时，记录rightListNodeHead(最后一段链表的头节点)为其下一个节点
                rightListNodeHead = current.getNext();
                // 不需要再遍历~
                break;
            }
            // 当前节点后移
            current = current.getNext();
            // 当前节点的前一个节点后移
            pre = pre.getNext();
        }
        // 翻转[left,right]
        ListNode[] middleList = reverseListNode(leftNode);
        // 拼接三段链表
        pre.setNext(middleList[0]);
        middleList[1].setNext(rightListNodeHead);
        return top.getNext();
    }

    /**
     * 倒置链表：返回链表的头尾节点，头节点为链表数组0位置的节点，尾结点为链表数组1位置的节点
     *
     * @param head 链表头
     * @return
     */
    private static ListNode[] reverseListNode(ListNode head) {
        // top节点：链表的总表头
        ListNode top = new ListNode(-1);
        top.setNext(head);
        // 当前节点
        ListNode current = head;
        // 当前节点的相邻前一个节点
        ListNode pre = top;
        // 未翻转链表的表头(即当前节点的下一个节点)
        ListNode restListHead = current.getNext();
        // 翻转后链表的表头和表尾
        ListNode[] result = new ListNode[2];

        while (current != null) {


            current = current.getNext();

        }
        return result;
    }
}
