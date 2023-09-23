package com.wp.main.leetcode.easy;

import com.wp.main.common.ListNode;

/**
 * @Description 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head，删除所有重复的元素，使每个元素只出现一次。返回已排序的链表。
 * <p>
 * <p>
 * 示例1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * 示例2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * <p>
 * <p>
 * 提示：
 * 链表中节点数目在范围[0, 300]内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 * @Author admin
 * @Date 2023/9/23 11:11
 */
public class LeetCode83 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        ListNode result = individualExecution(head);
        while (result != null) {
            System.out.print(result.getValue() + " ");
            result = result.getNext();
        }
    }

    /**
     * 个人思路：遍历当前节点时查询下一个节点，如果下一个节点不符合就跳过，设置当前节点的next节点为next.next
     *
     * @return
     */
    private static ListNode individualExecution(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(0);
        pre.setNext(head);
        // 设置遍历指针
        ListNode current = head;
        while (current != null && current.getNext() != null) {
            if (current.getValue().equals(current.getNext().getValue())) {
                /** 1、当前节点和下一个节点的数值重复 **/
                // 删除重复节点
                current.setNext(current.getNext().getNext());
            } else {
                /** 2、当前节点和下一个节点的数值不重复 **/
                // 当前指针后移
                current = current.getNext();
            }
        }
        return pre.getNext();
    }
}
