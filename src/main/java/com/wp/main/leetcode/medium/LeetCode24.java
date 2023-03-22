package com.wp.main.leetcode.medium;

import com.wp.main.common.ListNode;

/**
 * @Description 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 示例 1
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * @Author admin
 * @Date 2023/3/22 10:51
 */
public class LeetCode24 {
    public static void main(String[] args) {
        /*ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.setNext(node2);
        ListNode node3 = new ListNode(3);
        node2.setNext(node3);
        ListNode node4 = new ListNode(4);
        node3.setNext(node4);*/
        ListNode head = new ListNode(1);
        head = individualExecute(head);
        ListNode current = head;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    /**
     * 个人思路：
     * 设定一个辅助节点moveNode，用于2个节点的交换
     * (1)first.next = secode.next
     * (2)secode.next = first
     *
     * @param head
     * @return
     */
    private static ListNode individualExecute(ListNode head) {
        ListNode prev = new ListNode(-1);
        prev.setNext(head);
        ListNode top = new ListNode(-1);
        top.setNext(head);
        // 辅助节点，用于节点的两两交换
        ListNode firstNode = null;
        ListNode secondNode = null;
        // 遍历链表过程中的当前节点
        ListNode currentNode = head;
        int n = 0;
        while (true) {
            // 如果有1个为空节点则不用交换
            if (firstNode == null && secondNode == null && currentNode == null) {
                break;
            }
            if (firstNode == null) {
                firstNode = currentNode;
                currentNode = currentNode.getNext();
                continue;
            }
            if (secondNode == null) {
                secondNode = currentNode;
                currentNode = currentNode.getNext();
                continue;
            }
            // 换位处理
            n++;
            // 位置交换：主要就是交换节点的下一个位置
            firstNode.setNext(secondNode.getNext());
            secondNode.setNext(firstNode);
            prev.setNext(secondNode);
            if (n == 1) {
                // 如果是第一次交换，重新记录一下一下链表头的位置
                top.setNext(secondNode);
            }
            // 一组交换后调整辅助节点，用于下一次交换
            prev = firstNode;
            firstNode = null;
            secondNode = null;
        }
        return top.getNext();
    }

}
