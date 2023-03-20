package com.wp.main.leetcode.medium;

import com.wp.main.common.ListNode;

/**
 * @Description 删除链表的倒数第N个节点
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * @Author admin
 * @Date 2023/3/20 17:04
 */
public class LeetCode19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.setNext(node2);
        ListNode node3 = new ListNode(3);
        node2.setNext(node3);
        ListNode node4 = new ListNode(4);
        node3.setNext(node4);
        ListNode node5 = new ListNode(5);
        node4.setNext(node5);
        /*ListNode tail = new ListNode(-1);
        tail = head;
        while (tail != null) {
            System.out.println(tail.getValue());
            tail = tail.getNext();
        }*/
        int n = 2;
        ListNode result = individualExecute(head, n);
        while (result != null) {
            System.out.println(result.getValue());
            result = result.getNext();
        }
    }

    /**
     * 思路：
     * 1、遍历链表，获得链表长度
     * 2、从头部开始遍历链表，第length-n+1个节点是要清理的节点，由于是单向链表，因此要找到该节点的前一个节点，并记录要清理节点的
     * 下一个节点，这样才方便拼接。
     *
     * @param head 链表头部
     * @param n    要删除
     * @return
     */
    private static ListNode individualExecute(ListNode head, int n) {
        // 链表长度
        int length = 0;
        ListNode current = head;
        // 1、记录链表的长度
        while (current != null) {
            length++;
            current = current.getNext();
        }
        // 2、再次遍历链表，找到要清理的节点
        current = head;
        int m = 1;
        // 2.1、需要找到要清除节点的前一个节点
        while (m < length - n) {
            current = current.getNext();
            m++;
        }
        // 2.2、找到要清除节点的下一个节点
        ListNode joint = current.getNext().getNext();
        // 2.3、节点拼接，链表重组完成
        current.setNext(joint);
        return head;
    }
}
