package com.wp.main.leetcode.medium;

import com.wp.main.common.ListNode;

/**
 * Mark：
 * 1、个人思路中：如果增加一个pre节点指向head。那么head节点的特殊处理就相当于被消灭了，只需要对pre节点开始做通用处理即可
 * 2、堆栈：遍历链表时将信息放入堆栈，然后从堆栈开始弹出节点，第n个就是需要的节点
 * 3、双指针：一个指针先行n个位置，然后第二个指针和第一个指针一起移动，当第一个指针移动到末尾后即可获得倒数第n个节点
 */

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
public class LeetCode19Mark {
    public static void main(String[] args) {
        // 1、多个节点
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.setNext(node2);
        ListNode node3 = new ListNode(3);
        node2.setNext(node3);
        ListNode node4 = new ListNode(4);
        node3.setNext(node4);
        ListNode node5 = new ListNode(5);
        node4.setNext(node5);
        int n = 2;
        head = individualExecute(head, n);

        // 2、只有1个节点
        /*ListNode head = new ListNode(1);
        int n = 1;
        ListNode result = individualExecute(head, n);*/
        // 显示链表是否按预期拼接
        /*ListNode tail = new ListNode(-1);
        tail = head;
        while (tail != null) {
            System.out.println(tail.getValue());
            tail = tail.getNext();
        }*/

        // 打印结果
        while (head != null) {
            System.out.println(head.getValue());
            head = head.getNext();
        }
    }

    /**
     * 官方思路：双指针
     * 一个指针first先移动n位，然后second和first一起移动，当first移动到最后时，就找到了倒数第n个节点
     * @param head
     * @param n
     * @return
     */
    private static ListNode standardExecute(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.setNext(head);
        ListNode first = head;
        ListNode second = pre;
        for (int i = 0; i < n; i++) {
            first = first.getNext();
        }
        while (first != null) {
            first = first.getNext();
            second = second.getNext();
        }
        second.setNext(second.getNext().getNext());
        ListNode ans = pre.getNext();
        return ans;
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
        ListNode newHead = new ListNode(-1);
        head = newHead;
        return head;
        /*// 链表长度
        int length = 0;
        ListNode current = head;
        // 1、记录链表的长度
        while (current != null) {
            length++;
            current = current.getNext();
        }
        // 2、再次遍历链表，找到要清理的节点
        // 2.1、如果要清理的元素和链表长度相同，意味着清除链表头结点，返回链表的下一个节点即可
        if (n == length) {
            return head.getNext();
        }
        current = head;
        int m = 1;
        // 2.1、需要找到要清除节点的前一个节点
        while (m < length - n) {
            current = current.getNext();
            m++;
        }
        // 2.2、找到要清除节点的下一个节点
        // 下一个节点(要清除的节点)不为空，将当前节点和要清除节点的下一个节点进行拼接
        // 下一个节点(要清除的节点)不为空的情况，即current.getNext()!=null在第82行已经处理了，只要要清理的节点不是头部节点就不会出现current.getNext()==null
        ListNode joint = current.getNext().getNext();
        current.setNext(joint);
        return head;*/
    }
}
