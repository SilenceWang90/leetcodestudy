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
     * 个人思路：
     *
     * @param head 给定链表
     * @param x    指定参数
     * @return 返回重组链表
     */
    private static ListNode individual(ListNode head, int x) {
        ListNode top = new ListNode(0);
        top.setNext(head);


        return top.getNext();
    }
}
