package com.wp.main.leetcode.medium;

import com.wp.main.common.ListNode;

/**
 * @Description 分隔链表
 * 给你一个链表的头节点head和一个特定值x，请你对链表进行分隔，使得所有小于x的节点都出现在大于或等于x的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例 1：
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * <p>
 * 提示：
 * 链表中节点的数目在范围[0, 200]内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 * @Author admin
 * @Date 2023/9/30 12:14
 */
public class LeetCode86 {
    public static void main(String[] args) {

    }

    /**
     * 个人思路：两个链表分别维护比x小的节点以及比x大的节点，然后拼接2个节点
     *
     * @param head 给定链表
     * @param x    指定参数
     * @return 返回重组链表
     */
    private static ListNode individual(ListNode head, int x) {
        // 创建2个链表，一个存储比x大的链表，一个存储比x小的链表
        ListNode largerHead = new ListNode(0);
        ListNode largerTail = largerHead;
        ListNode smallerHead = new ListNode(0);
        ListNode smallerTail = smallerHead;
        // 遍历的当前节点
        ListNode current = head;
        // 节点遍历
        while (current != null) {
            if (current.getValue() < x) {
                smallerTail.setNext(current);
                smallerTail = smallerTail.getNext();
            } else {
                largerTail.setNext(current);
                largerTail = largerTail.getNext();
            }
            // 遍历下一个节点
            current = current.getNext();
        }
        // 拼接larger和smaller链表并返回
        largerTail.setNext(smallerHead);
        return largerHead;
    }
}
