package com.wp.main.leetcode.medium;

import com.wp.main.common.ListNode;

/**
 * @Description 旋转链表
 * 给你一个链表的头节点head，旋转链表，将链表每个节点向右移动k个位置
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * <p>
 * 示例 2：
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * <p>
 * 提示：
 * 链表中节点的数目在范围[0, 500]内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 * @Author admin
 * @Date 2023/6/24 11:50
 */
public class LeetCode61 {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        System.out.println(head);
    }

    /**
     * 个人思路：双指针
     * 1、一个指针先行k距离，然后另一个指针同步开始运行，直到先行指针到达最后一个位置，这样就找到了要调整到队列头的节点
     * 2、遍历剥离出来的指针，按照倒序放入一个辅助链表，然后插入到原链表头部即可
     *
     * @param head 链表
     * @param k    移动距离
     * @return
     */
    private static ListNode individualExecution(ListNode head, int k) {
        /** 1、特殊情况处理**/
        if (head == null) {
            return null;
        }
        ListNode preNode = new ListNode(-1);
        preNode.setNext(head);
        /** 2、递归链表获取要重置的节点**/
        // 双指针左节点
        ListNode left = head;
        // 双指针右节点
        ListNode right = head;
        ListNode current = head;
        // 左右节点距离
        int distance = 0;
        // 遍历链表
        while (right.getNext() != null) {
            // 只要队列下一个节点不为空则可移动左右指针；左指针节点视情况移动：如果左指针和右指针间距没有达到k，则左指针不动否则右指针移动
            if (distance < k) {
                distance++;
                right = right.getNext();
            } else {
                right = right.getNext();
                left = left.getNext();
            }
        }

        return preNode.getNext();
    }
}
