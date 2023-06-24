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
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(l4);
        l4.setNext(l5);
        System.out.println(individualExecution(l1, 2));
    }

    /**
     * 注：！！！！！！！！！！！！！！！
     * 该方法可优化：因为为了知道k是不是大于整个链表的长度，此时需要多一次遍历循环。但如果首位直接相连，那么就不需要这种操作，直接双指针开始移动然后找到要截断的位置即可。
     * ！！！！！！！！！！！！！！！！！
     * 个人思路：双指针
     * 1、一个指针先行k距离，然后另一个指针同步开始运行，直到先行指针到达最后一个位置，这样就找到了要调整到队列头的节点
     * 2、将剥离出来的链表加入到原链表的头部即可
     *
     * @param head 链表
     * @param k    移动距离
     * @return
     */
    private static ListNode individualExecution(ListNode head, int k) {
        /** 1、特殊情况处理**/
        // 1.1、list为空
        if (head == null) {
            return null;
        }
        // 1.2、获取链表的长度，如果k大于该值则我们只需要取模即可。因为我们只需要找到不满足整个链表移动的距离即可
        int length = 1;
        ListNode current = head;
        while (current.getNext() != null) {
            current = current.getNext();
            length++;
        }
        k = k % length;
        /** 2、递归链表获取要重置的节点**/
        ListNode preNode = new ListNode(-1);
        preNode.setNext(head);
        // 双指针左节点
        ListNode left = head;
        // 双指针右节点
        ListNode right = head;
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
        /** 3、截取队列后k个节点队列，就是left节点的next节点开始的全部节点。将该子链表加入到原链表的头部**/
        // 原尾部节点指向头部节点
        right.setNext(head);
        // left的下一个节点作为链表新的头部节点
        preNode.setNext(left.getNext());
        // left作为新队列的尾部节点
        left.setNext(null);
        return preNode.getNext();
    }
}
